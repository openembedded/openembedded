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
		bb.build.exec_func("__do_clean_make", d)
	except bb.build.FuncFailed:
		pass

__do_clean_make () {
	oe_runmake clean
}

python do_clean () {
	if bb.data.getVar("PSTAGING_ACTIVE", d, 1) == "1":
		removepkg = bb.data.expand("${PSTAGE_PKGPN}", d)
		pstage_cleanpackage(removepkg, d)

		stagepkg = bb.data.expand("${PSTAGE_PKG}", d)
		bb.note("Removing staging package %s" % base_path_out(stagepkg, d))
		os.system('rm -rf ' + stagepkg)
	clean_stamps(d)
	clean_workdir(d)
	clean_builddir(d)
	clean_make(d)
}
