python populate_packages_prepend () {
	import re, os.path

	new_packages = []

	def the_hook(file, pkg, pattern, format, basename):
		new_packages.append(pkg)

	do_split_packages(d, root=bb.data.expand('${libdir}/xorg/modules/drivers', d), file_regex='(.*)_drv\.so', output_pattern='xorg-driver-%s', description='xorg %s driver', extra_depends='xserver-xorg', hook=the_hook)

	packages = bb.data.getVar('PACKAGES', d, 1).split()

	so_to_la_re = "\.so$"

	# fish out any debug or devel files corresponding to the new packages
	for p in new_packages:
		packages.append("%s-dbg" % p)
		packages.append("%s-dev" % p)

		files = bb.data.getVar("FILES_%s" % p, d).split()
		dev_files = []
		dbg_files = []
		for f in files:
			dev_files.append(re.sub(so_to_la_re, ".la", f))
			(dir, file) = os.path.split(f)
			dbg_files.append(os.path.join(dir, ".debug", file))
		bb.data.setVar("FILES_%s-dbg" % p, " ".join(dbg_files), d)
		bb.data.setVar("FILES_%s-dev" % p, " ".join(dev_files), d)
	
	bb.data.setVar('PACKAGES', ' '.join(packages), d)
}
