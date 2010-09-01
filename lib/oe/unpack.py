import os.path
import bb

class UnpackError(Exception):
    def __init__(self, filename, destdir, command, output):
        self.filename = filename
        self.destdir = destdir
        self.command = command
        self.output = output

    def __str__(self):
        return "Unable to unpack '%s' to '%s' (cmd: %s): %s" % \
               (self.filename, self.destdir, self.command, self.output)

def to_boolean(string, default=None):
    if not string:
        return default

    normalized = string.lower()
    if normalized in ("y", "yes", "1", "true"):
        return True
    elif normalized in ("n", "no", "0", "false"):
        return False
    else:
        raise ValueError("Invalid value for to_boolean: %s" % string)

def is_patch(filename, parameters):
    try:
        apply = to_boolean(parameters.get("apply"))
    except ValueError, exc:
        bb.fatal("Invalid value for 'apply' parameter for %s: %s" %
                 (filename, parameters.get("apply")))

    if apply is not None:
        return apply

    if parameters.get("patch"):
        bb.msg.warn(None, "Deprecated usage of 'patch' url param for '%s', please use 'apply={yes,no}'" % filename)
        return True

    base, ext = os.path.splitext(filename)
    return ext in (".diff", ".patch")

def subprocess_setup():
    import signal
    # Python installs a SIGPIPE handler by default. This is usually not what
    # non-Python subprocesses expect.
    signal.signal(signal.SIGPIPE, signal.SIG_DFL)

def unpack_file(file, destdir, dos=False, env=None):
    import subprocess, shutil

    dest = os.path.join(destdir, os.path.basename(file))
    if os.path.exists(dest):
        if os.path.samefile(file, dest):
            return True

    cmd = None
    if file.endswith('.tar'):
        cmd = 'tar x --no-same-owner -f %s' % file
    elif file.endswith('.tgz') or file.endswith('.tar.gz') or file.endswith('.tar.Z'):
        cmd = 'tar xz --no-same-owner -f %s' % file
    elif file.endswith('.tbz') or file.endswith('.tbz2') or file.endswith('.tar.bz2'):
        cmd = 'bzip2 -dc %s | tar x --no-same-owner -f -' % file
    elif file.endswith('.gz') or file.endswith('.Z') or file.endswith('.z'):
        base, ext = os.path.splitext(file)
        cmd = 'gzip -dc %s > %s' % (file, base)
    elif file.endswith('.bz2'):
        base, ext = os.path.splitext(file)
        cmd = 'bzip2 -dc %s > %s' % (file, base)
    elif file.endswith('.tar.xz'):
        cmd = 'xz -dc %s | tar x --no-same-owner -f -' % file
    elif file.endswith('.xz'):
        base, ext = os.path.splitext(file)
        cmd = 'xz -dc %s > %s' % (file, base)
    elif file.endswith('.zip') or file.endswith('.jar'):
        cmd = 'unzip -q -o'
        if dos:
            cmd = '%s -a' % cmd
        cmd = "%s '%s'" % (cmd, file)
    elif os.path.isdir(file):
        shutil.rmtree(dest, True)
        shutil.copytree(file, dest, True)
    else:
        shutil.copy2(file, dest)

    if not cmd:
        return

    pipe = subprocess.Popen(cmd, preexec_fn=subprocess_setup, shell=True,
                            cwd=destdir, env=env, stdout=subprocess.PIPE,
                            stderr=subprocess.STDOUT)
    stdout = pipe.communicate()[0]
    if pipe.returncode != 0:
        raise UnpackError(file, destdir, cmd, stdout)
