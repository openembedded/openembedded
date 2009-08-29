# Copyright (C) 2009 Chris Larson <clarson@kergoth.com>
# Released under the MIT license (see COPYING.MIT for the terms)
#
# gitver.bbclass provides a GITVER variable which is a (fairly) sane version,
# for use in ${PV}, extracted from the ${S} git checkout, assuming it is one.
# This is most useful in concert with srctree.bbclass.


GITVER = "${@get_git_pv('${S}', d)}"

def gitver_mark_dependency(d):
    from bb.data import expand
    from bb.parse import mark_dependency
    from os.path import abspath

    fn = abspath(expand("${S}/.git/HEAD", d))
    mark_dependency(d, fn)

def get_git_pv(path, d, tagadjust=None):
    from subprocess import Popen, PIPE
    from os.path import join
    from bb import error

    env = {"GIT_DIR": join(d.getVar("S", True), ".git")}

    def popen(cmd, **kwargs):
        kwargs["stderr"] = PIPE
        kwargs["stdout"] = PIPE
        kwargs["env"] = env
        try:
            pipe = Popen(cmd, **kwargs)
        except OSError, e:
            #error("Execution of %s failed: %s" % (cmd, e))
            return

        (stdout, stderr) = pipe.communicate(None)
        if pipe.returncode != 0:
            #error("Execution of %s failed: %s" % (cmd, stderr))
            return
        return stdout.rstrip()

    gitver_mark_dependency(d)

    ver = popen(["git", "describe", "--tags"], cwd=path)
    if not ver:
        ver = popen(["git", "rev-parse", "--short", "HEAD"], cwd=path)
        if ver:
            return "0.0-%s" % ver
        else:
            return "0.0"
    else:
        if tagadjust:
            ver = tagadjust(ver)
        return ver
