import subprocess
import signal

def subprocess_setup():
    # Python installs a SIGPIPE handler by default. This is usually not what
    # non-Python subprocesses expect.
    signal.signal(signal.SIGPIPE, signal.SIG_DFL)

class CmdError(RuntimeError):
    def __init__(self, command):
        self.command = command

    def __str__(self):
        if not isinstance(self.command, basestring):
            cmd = subprocess.list2cmdline(self.command)
        else:
            cmd = self.command

        return "Execution of '%s' failed" % cmd

class NotFoundError(CmdError):
    def __str__(self):
        return CmdError.__str__(self) + ": command not found"

class ExecutionError(CmdError):
    def __init__(self, command, exitcode, stdout = None, stderr = None):
        CmdError.__init__(self, command)
        self.exitcode = exitcode
        self.stdout = stdout
        self.stderr = stderr

    def __str__(self):
        message = ""
        if self.stderr:
            message += self.stderr
        if self.stdout:
            message += self.stdout
        if message:
            message = ":\n" + message
        return (CmdError.__str__(self) +
                " with exit code %s" % self.exitcode + message)

def run(cmd, **kwargs):
    """Convenience function to run a command and return its output, raising an
    exception when the command fails"""
    from subprocess import PIPE, STDOUT

    options = {
        "stdout": PIPE,
        "stderr": STDOUT,
        "shell": False,
    }
    if isinstance(cmd, basestring):
        options["shell"] = True
    options.update(kwargs)
    try:
        pipe = popen(cmd, **options)
    except OSError, exc:
        if exc.errno == 2:
            raise NotFoundError(cmd)
        else:
            raise
    stdout, stderr = pipe.communicate()
    if pipe.returncode != 0:
        raise ExecutionError(cmd, pipe.returncode, stdout, stderr)
    return stdout

def popen(cmd, **kwargs):
    """ Convenience function to call out processes with our exported
    variables in the environment.
    """
    from subprocess import Popen

    kwargs["close_fds"] = True
    kwargs["preexec_fn"] = subprocess_setup

    return Popen(cmd, **kwargs)
