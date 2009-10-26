# Copyright (C) 2009 Chris Larson <clarson@kergoth.com>
# Released under the MIT license (see COPYING.MIT for the terms)
#
# gitver.bbclass provides a GITVER variable which is a (fairly) sane version,
# for use in ${PV}, extracted from the ${S} git checkout, assuming it is one.
# This is most useful in concert with srctree.bbclass.


GITVER = "${@get_git_pv('${S}', d)}"

def get_git_pv(path, d, tagadjust=None):
    from subprocess import Popen, PIPE
    import os
    from bb import error
    from bb.parse import mark_dependency

    gitdir = os.path.abspath(os.path.join(d.getVar("S", True), ".git"))
    env = { "GIT_DIR": gitdir }

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

    # Force the recipe to be reparsed so the version gets bumped
    # if the active branch is switched, or if the branch changes.
    mark_dependency(d, os.path.join(gitdir, "HEAD"))

    ref = popen(["git", "symbolic-ref", "HEAD"])
    reffile = os.path.join(gitdir, ref)
    if ref and os.path.exists(reffile):
        mark_dependency(d, reffile)
    else:
        # The ref might be hidden in packed-refs. Force a reparse if anything
        # in the working copy changes.
        mark_dependency(d, os.path.join(gitdir, "index"))

    # Catch new tags.
    tagdir = os.path.join(gitdir, "refs", "tags")
    if os.path.exists(tagdir):
        mark_dependency(d, tagdir)

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
