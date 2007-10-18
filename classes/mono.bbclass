def mono_find_provides_and_requires(files, d):
	provides = []
	requires = []
	
	import bb, os, commands
	
	pathprefix = "export PATH=%s; export LANG=; export LC_ALL=; " % bb.data.getVar('PATH', d, 1)
	for filename in files:
		if not filename.endswith(".dll") and not filename.endswith(".exe"):
			continue
		if not os.path.isfile(filename) or os.path.islink(filename):
			continue
		
		## Provides
		name, version = None, None
		
		ret, result = commands.getstatusoutput("%smonodis --assembly '%s'" % (pathprefix, filename))
		if ret:
			bb.error("raw_provides_and_requires: monodis --assembly '%s' failed, dependency information will be inaccurate" % filename)
			continue
		for line in result.splitlines():
			if not ":" in line: continue
			key, value = line.split(":", 1)
			if key.strip() == "Name":
				name = value.strip()
			elif key.strip() == "Version":
				version = value.strip()
		if name is not None and version is not None:
			if (name, version) not in provides:
				provides.append( (name, version) )
	
		## Requires
		name, version = None, None
		ret, result = commands.getstatusoutput("%smonodis --assemblyref '%s'" % (pathprefix, filename))
		if ret:
			bb.error("raw_provides_and_requires: monodis --assemblyref '%s' failed, dependency information will be inaccurate" % filename)
			continue
		for line in result.splitlines():
			if not "=" in line: continue
			key, value = line.split("=", 1)
			if ":" in key and key.split(":",1)[1].strip() == "Version":
				version = value.strip()
			elif key.strip() == "Name":
				name = value.strip()
        		if name is not None and version is not None:
				if (name, version) not in requires:
					requires.append( (name, version) )
				name, version = None, None
	
	# Remove everything from requires that's already in provides as it's not actually required
	# to be provided externally
	requires = [e for e in requires if not e in provides]
	return provides, requires

python mono_do_clilibs() {
	import bb, os, re, os.path

	exclude_clilibs = bb.data.getVar('EXCLUDE_FROM_CLILIBS', d, 0)
	if exclude_clilibs:
		bb.note("not generating clilibs")
		return
		
	lib_re = re.compile("^lib.*\.so")
	libdir_re = re.compile(".*/lib$")

	packages = bb.data.getVar('PACKAGES', d, 1)

	workdir = bb.data.getVar('WORKDIR', d, 1)
	if not workdir:
		bb.error("WORKDIR not defined")
		return

	staging = bb.data.getVar('STAGING_DIR', d, 1)
	if not staging:
		bb.error("STAGING_DIR not defined")
		return

	pkgdest = bb.data.getVar('PKGDEST', d, 1)

	clilibs_dir = os.path.join(staging, "clilibs")
	bb.mkdirhier(clilibs_dir)

	provides, requires = {}, {}
	private_libs = bb.data.getVar('PRIVATE_CLILIBS', d, 1)
	for pkg in packages.split():
		bb.debug(2, "calculating clilib provides for %s" % pkg)

		files_to_check = []
		top = os.path.join(pkgdest, pkg)
		for root, dirs, files in os.walk(top):
			for file in files:
				path = os.path.join(root, file)
				if file.endswith(".exe") or file.endswith(".dll"):
					files_to_check.append( path )
		provides[pkg], requires[pkg] = mono_find_provides_and_requires(files_to_check, d)
		clilibs_file = os.path.join(clilibs_dir, pkg + ".list")
		if os.path.exists(clilibs_file):
			os.remove(clilibs_file)
		if len(provides[pkg]) > 0:
			fd = open(clilibs_file, 'w')
			for s in provides[pkg]:
				fd.write(" ".join(s) + '\n')
			fd.close()

	clilib_provider = {}
	list_re = re.compile('^(.*)\.list$')
	for file in os.listdir(clilibs_dir):
		m = list_re.match(file)
		if m:
			dep_pkg = m.group(1)
			fd = open(os.path.join(clilibs_dir, file))
			lines = fd.readlines()
			fd.close()
			for l in lines:
				clilib_provider[tuple(l.rstrip().split())] = dep_pkg

	for pkg in packages.split():
		bb.debug(2, "calculating clilib requirements for %s" % pkg)

		deps = []
		for n in requires[pkg]:
			if n in clilib_provider.keys():
				dep_pkg = clilib_provider[n]

				if dep_pkg == pkg:
					continue
				
				if not dep_pkg in deps:
					deps.append(dep_pkg)
			else:
				bb.note("Couldn't find CLI library provider for %s" % (n,))

		deps_file = os.path.join(pkgdest, pkg + ".clilibdeps")
		if os.path.exists(deps_file):
			os.remove(deps_file)
		if len(deps) > 0:
			fd = open(deps_file, 'w')
			for dep in deps:
				fd.write(dep + '\n')
			fd.close()
}

do_mono_stage() {
        if [ "${INHIBIT_MONO_STAGE}" = "1" ]
        then
                return
        fi
	
	for package in ${PACKAGES}; do
		if [ -d  "${PKGDEST}/${package}/${libdir}" ]; then
			cd "${PKGDEST}/${package}/${libdir}"
			for file in `find . -iname "*.dll"`; do
				cp --parent -fpPR "${file}" "${STAGING_LIBDIR}/"
			done
		fi
	done
}
addtask mono_stage after do_package before do_populate_staging

def mono_after_parse(d):
	import bb
	# Insert mono_do_clilibs into PACKAGEFUNCS
	# Needs to be called after populate_packages, but before read_shlibdeps
	PACKAGEFUNCS = bb.data.getVar("PACKAGEFUNCS", d, 1)
	if PACKAGEFUNCS:
		PACKAGEFUNCS = PACKAGEFUNCS.split()
		if "read_shlibdeps" in PACKAGEFUNCS:
			i = PACKAGEFUNCS.index("read_shlibdeps")
			PACKAGEFUNCS.insert(i, "mono_do_clilibs")
		elif "populate_packages" in PACKAGEFUNCS:
			i = PACKAGEFUNCS.index("populate_packages")
			PACKAGEFUNCS.insert(i+1, "mono_do_clilibs")
		bb.data.setVar("PACKAGEFUNCS", " ".join(PACKAGEFUNCS), d)

python () {
    mono_after_parse(d)
}
