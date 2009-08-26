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

# Ensure that do_package depends on populate_staging, rather than install
addtask package after do_populate_staging

# This stuff is needed to facilitate variants (normal, native, cross, sdk)
# that share a ${S}.  It's ugly as hell.  Only really necessary for recipes
# that can't use a ${B}, and which have variants like native.  Not sure what
# the best solution is long term.
#
# We merge configure+compile+install into the populate_staging task, uses a
# lock file.  This ensures that none of the tasks which access ${S} can
# interleave amongst the recipes that share that ${S}.

def variant_hack(d):
	from itertools import chain

	# Kill dependencies on the fromtasks
	fromtasks = ["do_configure", "do_compile", "do_install"]
	for key in d.keys():
		task = d.getVarFlag(key, "task")
		if task:
			deps = d.getVarFlag(key, "deps")
			for task_ in fromtasks:
				if task_ in deps:
					deps.remove(task_)
			# if not key in fromtasks + ["do_populate_staging"]:
			#	 deps.append("do_populate_staging")
			d.setVarFlag(key, "deps", deps)

	# Pull the task deps from fromtasks over to the new task, minus deltasks
	deltasks = ("do_patch", "do_unpack", "do_fetch")
	deps = set(chain(*[(d.getVarFlag(old, "deps")) for old in fromtasks + ["do_populate_staging"]]))
	d.setVarFlag("do_populate_staging", "deps", deps.difference(deltasks))

	# Pull cross recipe task deps over
	d.setVarFlag("do_populate_staging", "depends", " ".join((d.getVarFlag(old, "depends") or "" for old in fromtasks)))

python () {
	variant_hack(d)
}

python do_populate_staging () {
	from bb.build import exec_task, exec_func

	exec_task("do_configure", d)
	exec_task("do_compile", d)
	exec_task("do_install", d)
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
