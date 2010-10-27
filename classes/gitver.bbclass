# Copyright (C) 2009 Chris Larson <clarson@kergoth.com>
# Released under the MIT license (see COPYING.MIT for the terms)
#
# gitver.bbclass provides a GITVER variable which is a (fairly) sane version,
# for use in ${PV}, extracted from the ${S} git checkout, assuming it is one.
# This is most useful in concert with srctree.bbclass.

def git_drop_tag_prefix(version):
    import re
    if re.match("v\d", version):
        return version[1:]
    else:
        return version

GIT_TAGADJUST = "git_drop_tag_prefix(version)"
GITVER = "${@get_git_pv('${S}', d, tagadjust=lambda version:${GIT_TAGADJUST})}"

def get_git_pv(path, d, tagadjust=None):
    import os
    from bb import error
    from bb.parse import mark_dependency
    import oe.process

    gitdir = os.path.abspath(os.path.join(d.getVar("S", True), ".git"))
    def git(cmd):
        try:
            return oe_run(d, ["git"] + cmd, cwd=gitdir).rstrip()
        except oe.process.CmdError, exc:
            bb.fatal(str(exc))

    # Force the recipe to be reparsed so the version gets bumped
    # if the active branch is switched, or if the branch changes.
    mark_dependency(d, os.path.join(gitdir, "HEAD"))

    # Force a reparse if anything in the index changes.
    mark_dependency(d, os.path.join(gitdir, "index"))

    try:
        ref = oe_run(d, ["git", "symbolic-ref", "-q", "HEAD"], cwd=gitdir).rstrip()
    except oe.process.CmdError:
        pass
    else:
        if ref:
            mark_dependency(d, os.path.join(gitdir, ref))

    # Catch new tags.
    tagdir = os.path.join(gitdir, "refs", "tags")
    if os.path.exists(tagdir):
        mark_dependency(d, tagdir)

    ver = git(["describe", "--tags"])
    if not ver:
        ver = git(["rev-parse", "--short", "HEAD"])
        if ver:
            return "0.0-%s" % ver
        else:
            return "0.0"
    else:
        if tagadjust:
            ver = tagadjust(ver)
        return ver
