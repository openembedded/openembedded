# Copyright (C) 2009 Chris Larson <clarson@kergoth.com>
# Released under the MIT license (see COPYING.MIT for the terms)
#
# This class uses events to capture the state of the datastore when the task
# starts, and after it completes.  It diffs those captured states, and emits
# messages showing which variables changed, and what their values were changed
# to.
#
# It provides a mechanism to blacklist variables you expect to change, both
# globally and on a per-task basis.
#
# Known instances of tasks changing metadata:
#
# PSTAGE_PKGMANAGER changes by calls to pstage_set_pkgmanager in:
#   do_clean, do_setscene, do_package_stage
#
# Subpackage metadata, read by the pkgdata functions in base.bbclass, in:
#   do_package, do_package_stage, do_package_write_*


TASK_METADATA_BLACKLIST = "\
    __RUNQUEUE_DO_NOT_USE_EXTERNALLY \
"

#TASK_METADATA_BLACKLIST_do_clean = "\
#    PSTAGE_PKGMANAGER \
#"


def dict_diff(olddict, newdict):
    diff = {}
    for key in set(olddict).union(set(newdict)):
        old = olddict.get(key)
        new = newdict.get(key)
        if old != new:
            diff[key] = (old, new)

    return diff

def dict_for_data(data):
    newdict = {}
    for key in data.keys():
        newdict[key] = data.getVar(key, False)
    return newdict

def task_metadata_track_start(task, data):
    originaldata = dict_for_data(data)
    data.setVar("__originaldata_%s" % task, originaldata)

def task_metadata_track_stop(task, data):
    from bb import note

    pf = data.getVar("PF", True)
    def emit(msg):
        note("%s: %s" % (pf, msg))

    originaldata = data.getVar("__originaldata_%s" % task, False)
    newdata = dict_for_data(data)
    blacklist = data.getVar("TASK_METADATA_BLACKLIST", True).split() + \
                (data.getVar("TASK_METADATA_BLACKLIST_%s" % task, True) or "").split()

    diff = dict_diff(originaldata, newdata)
    diff_clean = [key for key in diff \
                  if not key in blacklist and \
                  not key.startswith("__originaldata_")]

    if diff_clean:
        emit("Variables changed by %s:" % task)
        for key in diff_clean:
            (old, new) = diff[key]
            emit("  %s:" % key)
            emit("    '%s' -> '%s'" % (old, new))

python __task_metadata_track_eh () {
    from bb.build import TaskStarted, TaskSucceeded

    if isinstance(e, TaskStarted):
        if e.data is None:
            from bb import fatal
            fatal("e.data is none for %s" % e)
        task_metadata_track_start(e.task, e.data)
    elif isinstance(e, TaskSucceeded):
        task_metadata_track_stop(e.task, e.data)
}
addhandler __task_metadata_track_eh

addtask py_listtasks
do_py_listtasks[nostamp] = "1"
do_py_listtasks[recrdeptask] = "do_py_listtasks"
python do_py_listtasks() {
	import sys
	for e in d.keys():
		if d.getVarFlag(e, "task") and \
		   d.getVarFlag(e, "python"):
			sys.stdout.write("%s\n" % e)
}
