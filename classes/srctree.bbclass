# Copyright (C) 2009 Chris Larson <clarson@kergoth.com>
# Released under the MIT license (see COPYING.MIT for the terms)
#
# srctree.bbclass enables operation inside of an existing source tree for a
# project, rather than using the fetch/unpack/patch idiom.
#
# By default, it expects that you're keeping the recipe(s) inside the
# aforementioned source tree, but you could override S to point at an external
# directory and place the recipes in a normal collection/overlay, if you so
# chose.
#
# It also provides some convenience python functions for assembling your
# do_clean, if you want to leverage things like 'git clean' to simplify the
# operation.


S = "${FILE_DIRNAME}"
SRC_URI = ""

#TYPE = "${@'${PN}'.replace('${BPN}', '').strip()}"
#WORKDIR = "${S}/tmp${TYPE}.${MULTIMACH_HOST_SYS}"
#STAMP = "${WORKDIR}/tasks/stamp"
#WORKDIR_LOCAL = "${S}/tmp${TYPE}.${MULTIMACH_HOST_SYS}"
#T = "${WORKDIR_LOCAL}/bitbake-tasks"

# Hack, so things don't explode in builds that don't inherit package
do_package ?= "    pass"
do_package[func] = "1"
do_package[python] = "1"
addtask package after do_populate_staging

# This stuff is needed to facilitate variants (normal, native, cross, sdk)
# that share a ${S}.  It's ugly as hell.  Only really necessary for recipes
# that can't use a ${B}, and which have variants like native.  Not sure what
# the best solution is long term.
#
# We merge configure+compile+install into the populate_staging task, uses a
# lock file.  This ensures that none of the tasks which access ${S} can
# interleave amongst the recipes that share that ${S}.

def merge_tasks(d):
	"""
	merge_tasks performs two operations:
	1) removes do_patch and its deps from the build entirely.
	2) merges all of the operations that occur prior to do_populate_staging
	into do_populate_staging.

	This is necessary, because of recipe variants (normal, native, cross,
	sdk).  If a bitbake run happens to want to build more than one of
	these variants in a single run, it's possible for them to step on one
	another's toes, due to the shared ${S}.  Interleaved
	configure/compile/install amongst variants will break things badly.
	"""
	from itertools import chain
	from bb import note

	def __gather_taskdeps(task, seen):
		for dep in d.getVarFlag(task, "deps"):
			if not dep in seen:
				__gather_taskdeps(dep, seen)
		if not task in seen:
			seen.append(task)

	def gather_taskdeps(task):
		items = []
		__gather_taskdeps(task, items)
		return items

	newtask = "do_populate_staging"
	mergedtasks = gather_taskdeps(newtask)
	mergedtasks.pop()
	deltasks = gather_taskdeps("do_patch")

	for task in (key for key in d.keys()
	             if d.getVarFlag(key, "task") and
	             not key in mergedtasks):
		deps = d.getVarFlag(task, "deps")
		for mergetask in mergedtasks:
			if mergetask in (d.getVarFlag(task, "recrdeptask"),
			                 d.getVarFlag(task, "recdeptask"),
			                 d.getVarFlag(task, "deptask")):
				continue

			if mergetask in deps:
				deps.remove(mergetask)
				#note("removing dep on %s from %s" % (mergetask, task))

				if not mergetask in deltasks and \
				   not newtask in deps:
					#note("adding dep on %s to %s" % (newtask, task))
					deps.append(newtask)
		d.setVarFlag(task, "deps", deps)

	for task in mergedtasks[:-1]:
		deps = d.getVarFlag(task, "deps")
		for deltask in deltasks:
			if deltask in deps:
				deps.remove(deltask)
		d.setVarFlag(task, "deps", deps)

	# Pull cross recipe task deps over
	depends = (d.getVarFlag(task, "depends") or ""
	           for task in mergedtasks[:-1]
	           if not task in deltasks)
	d.setVarFlag("do_populate_staging", "depends", " ".join(depends))

python () {
    merge_tasks(d)
}

# Manually run do_install & all of its deps, then do_stage
python do_populate_staging () {
	from os.path import exists
	from bb.build import exec_task, exec_func
	from bb import note

	stamp = d.getVar("STAMP", True)

	def rec_exec_task(task, seen):
		for dep in d.getVarFlag(task, "deps"):
			if not dep in seen:
				rec_exec_task(dep, seen)
		seen.add(task)
		#if not exists("%s.%s" % (stamp, task)):
		note("Executing task %s" % task)
		exec_task(task, d)

	rec_exec_task("do_install", set())
	exec_func("do_stage", d)
}
do_populate_staging[lockfiles] += "${S}/.lock"

make_do_clean () {
	oe_runmake clean
}

def clean_builddir(d):
	from shutil import rmtree

	builddir = d.getVar("B", True)
	srcdir = d.getVar("S", True)
	if builddir != srcdir:
		rmtree(builddir, ignore_errors=True)

def clean_stamps(d):
	from glob import glob
	from bb import note
	from bb.data import expand
	from os import unlink

	note("Removing stamps")
	for stamp in glob(expand('${STAMP}.*', d)):
		try:
			unlink(stamp)
		except OSError:
			pass

def clean_workdir(d):
	from shutil import rmtree
	from bb import note

	workdir = d.getVar("WORKDIR", 1)
	note("Removing %s" % workdir)
	rmtree(workdir, ignore_errors=True)

def clean_git(d):
	from subprocess import call

	call(["git", "clean", "-d", "-f", "-X"], cwd=d.getVar("S", True))

def clean_make(d):
	import bb

	bb.note("Running make clean")
	try:
		bb.build.exec_func("make_do_clean", d)
	except bb.build.FuncFailed:
		pass

python do_clean () {
	clean_stamps(d)
	clean_workdir(d)
	clean_builddir(d)
	clean_make(d)
}
