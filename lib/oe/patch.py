import subprocess
import os
import oe.path
import oe.process
import bb.fetch, bb.data

class PatchError(Exception):
    def __init__(self, msg):
        self.msg = msg

    def __str__(self):
        return "Patch Error: %s" % self.msg

class PatchSet(object):
    defaults = {
        "strippath": 1
    }

    def __init__(self, dir, d):
        self.dir = dir
        self.d = d
        self.patches = []
        self._current = None
        self.env = {"PATH": d.getVar("PATH", True)}

    def current(self):
        return self._current

    def Clean(self):
        """
        Clean out the patch set.  Generally includes unapplying all
        patches and wiping out all associated metadata.
        """
        raise NotImplementedError()

    def Import(self, patch, force):
        if not patch.get("file"):
            if not patch.get("remote"):
                raise PatchError("Patch file must be specified in patch import.")
            else:
                patch["file"] = bb.fetch.localpath(patch["remote"], self.d)

        for param in PatchSet.defaults:
            if not patch.get(param):
                patch[param] = PatchSet.defaults[param]

        if patch.get("remote"):
            patch["file"] = bb.data.expand(bb.fetch.localpath(patch["remote"], self.d), self.d)

        patch["filemd5"] = bb.utils.md5_file(patch["file"])

    def Push(self, force):
        raise NotImplementedError()

    def Pop(self, force):
        raise NotImplementedError()

    def Refresh(self, remote = None, all = None):
        raise NotImplementedError()


class PatchTree(PatchSet):
    def __init__(self, dir, d):
        PatchSet.__init__(self, dir, d)

    def Import(self, patch, force = None):
        """"""
        PatchSet.Import(self, patch, force)

        if self._current is not None:
            i = self._current + 1
        else:
            i = 0
        self.patches.insert(i, patch)

    def _applypatch(self, patch, force = False, reverse = False, run = True):
        shellcmd = ["patch", "-p%s" % patch['strippath'], "-f"]
        if reverse:
            shellcmd.append('-R')

        if not run:
            return subprocess.list2cmdline(shellcmd)

        patch = open(patch['file'], "r")
        return oe.process.run(shellcmd, cwd=self.dir, env=self.env, stdin=patch)

    def Push(self, force = False, all = False, run = True):
        if all:
            for i in self.patches:
                if self._current is not None:
                    self._current = self._current + 1
                else:
                    self._current = 0
                self._applypatch(i, force)
        else:
            if self._current is not None:
                self._current = self._current + 1
            else:
                self._current = 0
            return self._applypatch(self.patches[self._current], force)


    def Pop(self, force = None, all = None):
        if all:
            for i in self.patches:
                self._applypatch(i, force, True)
        else:
            self._applypatch(self.patches[self._current], force, True)

    def Clean(self):
        """"""

class GitApplyTree(PatchTree):
    def __init__(self, dir, d):
        PatchTree.__init__(self, dir, d)

    def _applypatch(self, patch, force = False, reverse = False, run = True):
        shellcmd = ["git", "--git-dir=.", "apply", "-p%s" % patch['strippath']]

        if reverse:
            shellcmd.append('-R')

        shellcmd.append(patch['file'])

        if not run:
            return subprocess.list2cmdline(shellcmd)

        return oe.process.run(shellcmd, cwd=self.dir, env=self.env)


class QuiltTree(PatchSet):
    def _runcmd(self, args, run = True):
        quiltrc = bb.data.getVar('QUILTRCFILE', self.d, 1) or '-'
        cmdline = ["quilt", "--quiltrc=%s" % quiltrc] + args
        if not run:
            return subprocess.list2cmdline(cmdline)
        oe.process.run(cmdline, cwd=self.dir, env=self.env)

    def _quiltpatchpath(self, file):
        return os.path.join(self.dir, "patches", os.path.basename(file))


    def __init__(self, dir, d):
        PatchSet.__init__(self, dir, d)
        self.initialized = False
        p = os.path.join(self.dir, 'patches')
        if not os.path.exists(p):
            os.makedirs(p)

    def Clean(self):
        try:
            self._runcmd(["pop", "-a", "-f"])
            oe.path.remove(os.path.join(self.dir, "patches","series"))
        except Exception:
            pass
        self.initialized = True

    def InitFromDir(self):
        # read series -> self.patches
        seriespath = os.path.join(self.dir, 'patches', 'series')
        if not os.path.exists(self.dir):
            raise Exception("Error: %s does not exist." % self.dir)
        if os.path.exists(seriespath):
            series = file(seriespath, 'r')
            for line in series.readlines():
                patch = {}
                parts = line.strip().split()
                patch["quiltfile"] = self._quiltpatchpath(parts[0])
                patch["quiltfilemd5"] = bb.utils.md5_file(patch["quiltfile"])
                if len(parts) > 1:
                    patch["strippath"] = parts[1][2:]
                self.patches.append(patch)
            series.close()

            # determine which patches are applied -> self._current
            try:
                output = oe.process.run(["quilt", "applied"], cwd=self.dir, \
                                        env=self.env)
            except oe.process.ExecutionError, exc:
                if exc.stdout.strip() != "No patches applied":
                    raise
            output = [val for val in output.split('\n') if not val.startswith('#')]
            for patch in self.patches:
                if os.path.basename(patch["quiltfile"]) == output[-1]:
                    self._current = self.patches.index(patch)
        self.initialized = True

    def Import(self, patch, force = None):
        if not self.initialized:
            self.InitFromDir()
        PatchSet.Import(self, patch, force)
        oe.path.symlink(patch["file"], self._quiltpatchpath(patch["file"]))
        f = open(os.path.join(self.dir, "patches","series"), "a");
        f.write(os.path.basename(patch["file"]) + " -p" + patch["strippath"]+"\n")
        f.close()
        patch["quiltfile"] = self._quiltpatchpath(patch["file"])
        patch["quiltfilemd5"] = bb.utils.md5_file(patch["quiltfile"])

        # TODO: determine if the file being imported:
        #      1) is already imported, and is the same
        #      2) is already imported, but differs

        self.patches.insert(self._current or 0, patch)


    def Push(self, force = False, all = False, run = True):
        # quilt push [-f]

        args = ["push"]
        if force:
            args.append("-f")
        if all:
            args.append("-a")
        if not run:
            return self._runcmd(args, run)

        self._runcmd(args)

        if self._current is not None:
            self._current = self._current + 1
        else:
            self._current = 0

    def Pop(self, force = None, all = None):
        # quilt pop [-f]
        args = ["pop"]
        if force:
            args.append("-f")
        if all:
            args.append("-a")

        self._runcmd(args)

        if self._current == 0:
            self._current = None

        if self._current is not None:
            self._current = self._current - 1

    def Refresh(self, **kwargs):
        if kwargs.get("remote"):
            patch = self.patches[kwargs["patch"]]
            if not patch:
                raise PatchError("No patch found at index %s in patchset." % kwargs["patch"])
            (type, host, path, user, pswd, parm) = bb.decodeurl(patch["remote"])
            if type == "file":
                import shutil
                if not patch.get("file") and patch.get("remote"):
                    patch["file"] = bb.fetch.localpath(patch["remote"], self.d)

                shutil.copyfile(patch["quiltfile"], patch["file"])
            else:
                raise PatchError("Unable to do a remote refresh of %s, unsupported remote url scheme %s." % (os.path.basename(patch["quiltfile"]), type))
        else:
            # quilt refresh
            args = ["refresh"]
            if kwargs.get("quiltfile"):
                args.append(os.path.basename(kwargs["quiltfile"]))
            elif kwargs.get("patch"):
                args.append(os.path.basename(self.patches[kwargs["patch"]]["quiltfile"]))
            self._runcmd(args)

class Resolver(object):
    def __init__(self, patchset):
        raise NotImplementedError()

    def Resolve(self):
        raise NotImplementedError()

    def Revert(self):
        raise NotImplementedError()

    def Finalize(self):
        raise NotImplementedError()

class NOOPResolver(Resolver):
    def __init__(self, patchset):
        self.patchset = patchset

    def Resolve(self):
        olddir = os.path.abspath(os.curdir)
        os.chdir(self.patchset.dir)
        try:
            self.patchset.Push()
        except Exception:
            import sys
            os.chdir(olddir)
            raise sys.exc_value

# Patch resolver which relies on the user doing all the work involved in the
# resolution, with the exception of refreshing the remote copy of the patch
# files (the urls).
class UserResolver(Resolver):
    def __init__(self, patchset):
        self.patchset = patchset

    # Force a push in the patchset, then drop to a shell for the user to
    # resolve any rejected hunks
    def Resolve(self):

        olddir = os.path.abspath(os.curdir)
        os.chdir(self.patchset.dir)
        try:
            self.patchset.Push(False)
        except oe.process.CmdError:
            # Patch application failed
            patchcmd = self.patchset.Push(True, False, False)

            t = bb.data.getVar('T', self.patchset.d, 1)
            if not t:
                bb.msg.fatal(bb.msg.domain.Build, "T not set")
            bb.mkdirhier(t)
            import random
            rcfile = "%s/bashrc.%s.%s" % (t, str(os.getpid()), random.random())
            f = open(rcfile, "w")
            f.write("echo '*** Manual patch resolution mode ***'\n")
            f.write("echo 'Dropping to a shell, so patch rejects can be fixed manually.'\n")
            f.write("echo 'Run \"quilt refresh\" when patch is corrected, press CTRL+D to exit.'\n")
            f.write("echo ''\n")
            f.write(" ".join(patchcmd) + "\n")
            f.write("#" + bb.data.getVar('TERMCMDRUN', self.patchset.d, 1))
            f.close()
            os.chmod(rcfile, 0775)

            os.environ['TERMWINDOWTITLE'] = "Bitbake: Please fix patch rejects manually"
            os.environ['TERMRCFILE'] = rcfile
            rc = os.system(bb.data.getVar('TERMCMDRUN', self.patchset.d, 1))
            if os.WIFEXITED(rc) and os.WEXITSTATUS(rc) != 0:
                bb.msg.fatal(bb.msg.domain.Build, ("Cannot proceed with manual patch resolution - '%s' not found. " \
                    + "Check TERMCMDRUN variable.") % bb.data.getVar('TERMCMDRUN', self.patchset.d, 1))

            # Construct a new PatchSet after the user's changes, compare the
            # sets, checking patches for modifications, and doing a remote
            # refresh on each.
            oldpatchset = self.patchset
            self.patchset = oldpatchset.__class__(self.patchset.dir, self.patchset.d)

            for patch in self.patchset.patches:
                oldpatch = None
                for opatch in oldpatchset.patches:
                    if opatch["quiltfile"] == patch["quiltfile"]:
                        oldpatch = opatch

                if oldpatch:
                    patch["remote"] = oldpatch["remote"]
                    if patch["quiltfile"] == oldpatch["quiltfile"]:
                        if patch["quiltfilemd5"] != oldpatch["quiltfilemd5"]:
                            bb.note("Patch %s has changed, updating remote url %s" % (os.path.basename(patch["quiltfile"]), patch["remote"]))
                            # user change?  remote refresh
                            self.patchset.Refresh(remote=True, patch=self.patchset.patches.index(patch))
                        else:
                            # User did not fix the problem.  Abort.
                            raise PatchError("Patch application failed, and user did not fix and refresh the patch.")
        except Exception:
            os.chdir(olddir)
            raise
        os.chdir(olddir)
