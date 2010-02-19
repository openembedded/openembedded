#
# General packaging help functions
#

PKGD    = "${WORKDIR}/package"
PKGDEST = "${WORKDIR}/packages-split"

PKGV	?= "${PV}"
PKGR	?= "${PR}${DISTRO_PR}"

EXTENDPKGEVER = "${@['','${PKGE\x7d:'][bb.data.getVar('PKGE',d,1) > 0]}"
EXTENDPKGV ?= "${EXTENDPKGEVER}${PKGV}-${PKGR}"

def legitimize_package_name(s):
	"""
	Make sure package names are legitimate strings
	"""
	import re

	def fixutf(m):
		cp = m.group(1)
		if cp:
			return ('\u%s' % cp).decode('unicode_escape').encode('utf-8')

	# Handle unicode codepoints encoded as <U0123>, as in glibc locale files.
	s = re.sub('<U([0-9A-Fa-f]{1,4})>', fixutf, s)

	# Remaining package name validity fixes
	return s.lower().replace('_', '-').replace('@', '+').replace(',', '+').replace('/', '-')

def do_split_packages(d, root, file_regex, output_pattern, description, postinst=None, recursive=False, hook=None, extra_depends=None, aux_files_pattern=None, postrm=None, allow_dirs=False, prepend=False, match_path=False, aux_files_pattern_verbatim=None, allow_links=False):
	"""
	Used in .bb files to split up dynamically generated subpackages of a 
	given package, usually plugins or modules.
	"""

	dvar = bb.data.getVar('PKGD', d, True)

	packages = bb.data.getVar('PACKAGES', d, True).split()

	if postinst:
		postinst = '#!/bin/sh\n' + postinst + '\n'
	if postrm:
		postrm = '#!/bin/sh\n' + postrm + '\n'
	if not recursive:
		objs = os.listdir(dvar + root)
	else:
		objs = []
		for walkroot, dirs, files in os.walk(dvar + root):
			for file in files:
				relpath = os.path.join(walkroot, file).replace(dvar + root + '/', '', 1)
				if relpath:
					objs.append(relpath)

	if extra_depends == None:
		# This is *really* broken
		mainpkg = packages[0]
		# At least try and patch it up I guess...
		if mainpkg.find('-dbg'):
			mainpkg = mainpkg.replace('-dbg', '')
		if mainpkg.find('-dev'):
			mainpkg = mainpkg.replace('-dev', '')
		extra_depends = mainpkg

	for o in objs:
		import re, stat
		if match_path:
			m = re.match(file_regex, o)
		else:
			m = re.match(file_regex, os.path.basename(o))
		
		if not m:
			continue
		f = os.path.join(dvar + root, o)
		mode = os.lstat(f).st_mode
		if not (stat.S_ISREG(mode) or (allow_links and stat.S_ISLNK(mode)) or (allow_dirs and stat.S_ISDIR(mode))):
			continue
		on = legitimize_package_name(m.group(1))
		pkg = output_pattern % on
		if not pkg in packages:
			if prepend:
				packages = [pkg] + packages
			else:
				packages.append(pkg)
			the_files = [os.path.join(root, o)]
			if aux_files_pattern:
				if type(aux_files_pattern) is list:
					for fp in aux_files_pattern:
						the_files.append(fp % on)	
				else:
					the_files.append(aux_files_pattern % on)
			if aux_files_pattern_verbatim:
				if type(aux_files_pattern_verbatim) is list:
					for fp in aux_files_pattern_verbatim:
						the_files.append(fp % m.group(1))	
				else:
					the_files.append(aux_files_pattern_verbatim % m.group(1))
			bb.data.setVar('FILES_' + pkg, " ".join(the_files), d)
			if extra_depends != '':
				the_depends = bb.data.getVar('RDEPENDS_' + pkg, d, True)
				if the_depends:
					the_depends = '%s %s' % (the_depends, extra_depends)
				else:
					the_depends = extra_depends
				bb.data.setVar('RDEPENDS_' + pkg, the_depends, d)
			bb.data.setVar('DESCRIPTION_' + pkg, description % on, d)
			if postinst:
				bb.data.setVar('pkg_postinst_' + pkg, postinst, d)
			if postrm:
				bb.data.setVar('pkg_postrm_' + pkg, postrm, d)
		else:
			oldfiles = bb.data.getVar('FILES_' + pkg, d, True)
			if not oldfiles:
				bb.fatal("Package '%s' exists but has no files" % pkg)
			bb.data.setVar('FILES_' + pkg, oldfiles + " " + os.path.join(root, o), d)
		if callable(hook):
			hook(f, pkg, file_regex, output_pattern, m.group(1))

	bb.data.setVar('PACKAGES', ' '.join(packages), d)

PACKAGE_DEPENDS += "file-native"

def package_stash_hook(func, name, d):
	import bb, os.path
	body = bb.data.getVar(func, d, True)
	pn = bb.data.getVar('PN', d, True)
	staging = bb.data.getVar('PKGDATA_DIR', d, True)
	dirname = os.path.join(staging, 'hooks', name)
	bb.mkdirhier(dirname)
	fn = os.path.join(dirname, pn)
	f = open(fn, 'w')
	f.write("python () {\n");
	f.write(body);
	f.write("}\n");
	f.close()

python () {
    if bb.data.getVar('PACKAGES', d, True) != '':
        deps = bb.data.getVarFlag('do_package', 'depends', d) or ""
        for dep in (bb.data.getVar('PACKAGE_DEPENDS', d, True) or "").split():
            deps += " %s:do_populate_staging" % dep
        bb.data.setVarFlag('do_package', 'depends', deps, d)

        deps = (bb.data.getVarFlag('do_package', 'deptask', d) or "").split()
        # shlibs requires any DEPENDS to have already packaged for the *.list files
        deps.append("do_package")
        bb.data.setVarFlag('do_package', 'deptask', " ".join(deps), d)
}

def runstrip(file, d):
    # Function to strip a single file, called from populate_packages below
    # A working 'file' (one which works on the target architecture)
    # is necessary for this stuff to work, hence the addition to do_package[depends]

    import commands, stat

    pathprefix = "export PATH=%s; " % bb.data.getVar('PATH', d, True)
    magicfile = "%s/file/magic" % bb.data.getVar('STAGING_DATADIR_NATIVE', d, True) 

    ret, result = commands.getstatusoutput("%sfile -m %s '%s'" % (pathprefix, magicfile, file))

    if ret:
        bb.error("runstrip: 'file -m %s %s' failed (forced strip)" % (magicfile, file))

    if "not stripped" not in result:
        bb.debug(1, "runstrip: skip %s" % file)
        return 0

    # If the file is in a .debug directory it was already stripped,
    # don't do it again...
    if os.path.dirname(file).endswith(".debug"):
        bb.debug(2, "Already ran strip on %s" % file)
        return 0

    strip = bb.data.getVar("STRIP", d, True)
    objcopy = bb.data.getVar("OBJCOPY", d, True)

    newmode = None
    if not os.access(file, os.W_OK):
        origmode = os.stat(file)[stat.ST_MODE]
        newmode = origmode | stat.S_IWRITE
        os.chmod(file, newmode)

    extraflags = ""
    if ".so" in file and "shared" in result:
        extraflags = "--remove-section=.comment --remove-section=.note --strip-unneeded"
    elif "shared" in result or "executable" in result:
        extraflags = "--remove-section=.comment --remove-section=.note"
    elif file.endswith(".a"):
        extraflags = "--remove-section=.comment --strip-debug"


    bb.mkdirhier(os.path.join(os.path.dirname(file), ".debug"))
    debugfile=os.path.join(os.path.dirname(file), ".debug", os.path.basename(file))

    stripcmd = "'%s' %s '%s'" % (strip, extraflags, file)
    bb.debug(1, "runstrip: %s" % stripcmd)

    os.system("%s'%s' --only-keep-debug '%s' '%s'" % (pathprefix, objcopy, file, debugfile))
    ret = os.system("%s%s" % (pathprefix, stripcmd))
    os.system("%s'%s' --add-gnu-debuglink='%s' '%s'" % (pathprefix, objcopy, debugfile, file))

    if newmode:
        os.chmod(file, origmode)

    if ret:
        bb.error("runstrip: '%s' strip command failed" % stripcmd)

    return 1

PACKAGESTRIPFUNCS += "do_runstrip"
python do_runstrip() {
	import stat

	dvar = bb.data.getVar('PKGD', d, True)
	def isexec(path):
		try:
			s = os.stat(path)
		except (os.error, AttributeError):
			return 0
		return (s[stat.ST_MODE] & stat.S_IEXEC)

	for root, dirs, files in os.walk(dvar):
		for f in files:
			file = os.path.join(root, f)
			if not os.path.islink(file) and not os.path.isdir(file) and isexec(file):
				runstrip(file, d)
}


def write_package_md5sums (root, outfile, ignorepaths):
    # For each regular file under root, writes an md5sum to outfile.
    # With thanks to patch.bbclass.
    import bb, os

    try:
        # Python 2.5+
        import hashlib
        ctor = hashlib.md5
    except ImportError:
        import md5
        ctor = md5.new

    outf = file(outfile, 'w')

    # Each output line looks like: "<hex...>  <filename without leading slash>"
    striplen = len(root)
    if not root.endswith('/'):
        striplen += 1

    for walkroot, dirs, files in os.walk(root):
        # Skip e.g. the DEBIAN directory
        if walkroot[striplen:] in ignorepaths:
            dirs[:] = []
            continue

        for name in files:
            fullpath = os.path.join(walkroot, name)
            if os.path.islink(fullpath) or (not os.path.isfile(fullpath)):
                continue

            m = ctor()
            f = file(fullpath, 'rb')
            while True:
                d = f.read(8192)
                if not d:
                    break
                m.update(d)
            f.close()

            print >> outf, "%s  %s" % (m.hexdigest(), fullpath[striplen:])

    outf.close()


#
# Package data handling routines
#

def get_package_mapping (pkg, d):
	data = read_subpkgdata(pkg, d)
	key = "PKG_%s" % pkg

	if key in data:
		return data[key]

	return pkg

def runtime_mapping_rename (varname, d):
	#bb.note("%s before: %s" % (varname, bb.data.getVar(varname, d, True)))	

	new_depends = []
	for depend in explode_deps(bb.data.getVar(varname, d, True) or ""):
		# Have to be careful with any version component of the depend
		split_depend = depend.split(' (')
		new_depend = get_package_mapping(split_depend[0].strip(), d)
		if len(split_depend) > 1:
			new_depends.append("%s (%s" % (new_depend, split_depend[1]))
		else:
			new_depends.append(new_depend)

	bb.data.setVar(varname, " ".join(new_depends) or None, d)

	#bb.note("%s after: %s" % (varname, bb.data.getVar(varname, d, True)))

#
# Package functions suitable for inclusion in PACKAGEFUNCS
#

python package_do_split_locales() {
	if (bb.data.getVar('PACKAGE_NO_LOCALE', d, True) == '1'):
		bb.debug(1, "package requested not splitting locales")
		return

	packages = (bb.data.getVar('PACKAGES', d, True) or "").split()

	datadir = bb.data.getVar('datadir', d, True)
	if not datadir:
		bb.note("datadir not defined")
		return

	dvar = bb.data.getVar('PKGD', d, True)
	pn = bb.data.getVar('PN', d, True)

	if pn + '-locale' in packages:
		packages.remove(pn + '-locale')

	localedir = os.path.join(dvar + datadir, 'locale')

	if not os.path.isdir(localedir):
		bb.debug(1, "No locale files in this package")
		return

	locales = os.listdir(localedir)

	# This is *really* broken
	mainpkg = packages[0]
	# At least try and patch it up I guess...
	if mainpkg.find('-dbg'):
		mainpkg = mainpkg.replace('-dbg', '')
	if mainpkg.find('-dev'):
		mainpkg = mainpkg.replace('-dev', '')

	for l in locales:
		ln = legitimize_package_name(l)
		pkg = pn + '-locale-' + ln
		packages.append(pkg)
		bb.data.setVar('FILES_' + pkg, os.path.join(datadir, 'locale', l), d)
		bb.data.setVar('RDEPENDS_' + pkg, '%s virtual-locale-%s' % (mainpkg, ln), d)
		bb.data.setVar('RPROVIDES_' + pkg, '%s-locale %s-translation' % (pn, ln), d)
		bb.data.setVar('DESCRIPTION_' + pkg, '%s translation for %s' % (l, pn), d)

	bb.data.setVar('PACKAGES', ' '.join(packages), d)
}

python perform_packagecopy () {
	dest = bb.data.getVar('D', d, True)
	dvar = bb.data.getVar('PKGD', d, True)

	bb.mkdirhier(dvar)

	# Start by package population by taking a copy of the installed 
	# files to operate on
	os.system('rm -rf %s/*' % (dvar))
	os.system('cp -pPR %s/* %s/' % (dest, dvar))
}

python populate_packages () {
	import glob, errno, re,os

	workdir = bb.data.getVar('WORKDIR', d, True)
	outdir = bb.data.getVar('DEPLOY_DIR', d, True)
	dvar = bb.data.getVar('PKGD', d, True)
	packages = bb.data.getVar('PACKAGES', d, True)
	pn = bb.data.getVar('PN', d, True)

	bb.mkdirhier(outdir)
	os.chdir(dvar)

	# Sanity check PACKAGES for duplicates - should be moved to 
	# sanity.bbclass once we have the infrastucture
	package_list = []
	for pkg in packages.split():
		if pkg in package_list:
			bb.error("-------------------")
			bb.error("%s is listed in PACKAGES multiple times, this leads to packaging errors." % pkg)
			bb.error("Please fix the metadata/report this as bug to OE bugtracker.")
			bb.error("-------------------")
		else:
			package_list.append(pkg)


	if (bb.data.getVar('INHIBIT_PACKAGE_STRIP', d, True) != '1'):
		for f in (bb.data.getVar('PACKAGESTRIPFUNCS', d, True) or '').split():
			bb.build.exec_func(f, d)

	pkgdest = bb.data.getVar('PKGDEST', d, True)
	os.system('rm -rf %s' % pkgdest)

	seen = []
	main_is_empty = 1
	main_pkg = bb.data.getVar('PN', d, True)

	for pkg in package_list:
		localdata = bb.data.createCopy(d)
		root = os.path.join(pkgdest, pkg)
		bb.mkdirhier(root)

		bb.data.setVar('PKG', pkg, localdata)
		overrides = bb.data.getVar('OVERRIDES', localdata, True)
		if not overrides:
			raise bb.build.FuncFailed('OVERRIDES not defined')
		bb.data.setVar('OVERRIDES', overrides + ':' + pkg, localdata)
		bb.data.update_data(localdata)

		filesvar = bb.data.getVar('FILES', localdata, True) or ""
		files = filesvar.split()
		for file in files:
			if os.path.isabs(file):
				file = '.' + file
			if not os.path.islink(file):
				if os.path.isdir(file):
					newfiles =  [ os.path.join(file,x) for x in os.listdir(file) ]
					if newfiles:
						files += newfiles
						continue
			globbed = glob.glob(file)
			if globbed:
				if [ file ] != globbed:
					if not file in globbed:
						files += globbed
						continue
					else:
						globbed.remove(file)
						files += globbed
			if (not os.path.islink(file)) and (not os.path.exists(file)):
				continue
			if file in seen:
				continue
			seen.append(file)
			if os.path.isdir(file) and not os.path.islink(file):
				bb.mkdirhier(os.path.join(root,file))
				os.chmod(os.path.join(root,file), os.stat(file).st_mode)
				continue
			fpath = os.path.join(root,file)
			dpath = os.path.dirname(fpath)
			bb.mkdirhier(dpath)
			ret = bb.copyfile(file, fpath)
			if ret is False:
				raise bb.build.FuncFailed("File population failed when copying %s to %s" % (file, fpath))
			if pkg == main_pkg and main_is_empty:
				main_is_empty = 0
		del localdata
	os.chdir(workdir)

	unshipped = []
	for root, dirs, files in os.walk(dvar):
		for f in files:
			path = os.path.join(root[len(dvar):], f)
			if ('.' + path) not in seen:
				unshipped.append(path)

	if unshipped != []:
		bb.note("the following files were installed but not shipped in any package:")
		for f in unshipped:
			bb.note("  " + f)

	bb.build.exec_func("package_name_hook", d)

	for pkg in package_list:
		pkgname = bb.data.getVar('PKG_%s' % pkg, d, True)
		if pkgname is None:
			bb.data.setVar('PKG_%s' % pkg, pkg, d)

	dangling_links = {}
	pkg_files = {}
	for pkg in package_list:
		dangling_links[pkg] = []
		pkg_files[pkg] = []
		inst_root = os.path.join(pkgdest, pkg)
		for root, dirs, files in os.walk(inst_root):
			for f in files:
				path = os.path.join(root, f)
				rpath = path[len(inst_root):]
				pkg_files[pkg].append(rpath)
				try:
					s = os.stat(path)
				except OSError, (err, strerror):
					if err != errno.ENOENT:
						raise
					target = os.readlink(path)
					if target[0] != '/':
						target = os.path.join(root[len(inst_root):], target)
					dangling_links[pkg].append(os.path.normpath(target))

	for pkg in package_list:
		rdepends = explode_deps(bb.data.getVar('RDEPENDS_' + pkg, d, 0) or bb.data.getVar('RDEPENDS', d, 0) or "")

		remstr = "${PN} (= ${EXTENDPKGV})"
		if main_is_empty and remstr in rdepends:
			rdepends.remove(remstr)
		for l in dangling_links[pkg]:
			found = False
			bb.debug(1, "%s contains dangling link %s" % (pkg, l))
			for p in package_list:
				for f in pkg_files[p]:
					if f == l:
						found = True
						bb.debug(1, "target found in %s" % p)
						if p == pkg:
							break
						if not p in rdepends:
							rdepends.append(p)
						break
			if found == False:
				bb.note("%s contains dangling symlink to %s" % (pkg, l))
		bb.data.setVar('RDEPENDS_' + pkg, " " + " ".join(rdepends), d)
}
populate_packages[dirs] = "${D}"

python emit_pkgdata() {
	from glob import glob

	def write_if_exists(f, pkg, var):
		def encode(str):
			import codecs
			c = codecs.getencoder("string_escape")
			return c(str)[0]

		val = bb.data.getVar('%s_%s' % (var, pkg), d, True)
		if val:
			f.write('%s_%s: %s\n' % (var, pkg, encode(val)))
 			return
 		val = bb.data.getVar('%s' % (var), d, True)
 		if val:
 			f.write('%s: %s\n' % (var, encode(val)))
 		return

	packages = bb.data.getVar('PACKAGES', d, True)
	pkgdest = bb.data.getVar('PKGDEST', d, 1)
	pkgdatadir = bb.data.getVar('PKGDATA_DIR', d, True)

	pstageactive = bb.data.getVar('PSTAGING_ACTIVE', d, True)
	if pstageactive == "1":
		lf = bb.utils.lockfile(bb.data.expand("${STAGING_DIR}/staging.lock", d))

	data_file = pkgdatadir + bb.data.expand("/${PN}" , d)
	f = open(data_file, 'w')
	f.write("PACKAGES: %s\n" % packages)
	f.close()
	package_stagefile(data_file, d)

	workdir = bb.data.getVar('WORKDIR', d, True)

	for pkg in packages.split():
		subdata_file = pkgdatadir + "/runtime/%s" % pkg
		sf = open(subdata_file, 'w')
		write_if_exists(sf, pkg, 'PN')
		write_if_exists(sf, pkg, 'PV')
		write_if_exists(sf, pkg, 'PR')
		write_if_exists(sf, pkg, 'PKGV')
		write_if_exists(sf, pkg, 'PKGR')
		write_if_exists(sf, pkg, 'DESCRIPTION')
		write_if_exists(sf, pkg, 'RDEPENDS')
		write_if_exists(sf, pkg, 'RPROVIDES')
		write_if_exists(sf, pkg, 'RRECOMMENDS')
		write_if_exists(sf, pkg, 'RSUGGESTS')
		write_if_exists(sf, pkg, 'RREPLACES')
		write_if_exists(sf, pkg, 'RCONFLICTS')
		write_if_exists(sf, pkg, 'PKG')
		write_if_exists(sf, pkg, 'ALLOW_EMPTY')
		write_if_exists(sf, pkg, 'FILES')
		write_if_exists(sf, pkg, 'pkg_postinst')
		write_if_exists(sf, pkg, 'pkg_postrm')
		write_if_exists(sf, pkg, 'pkg_preinst')
		write_if_exists(sf, pkg, 'pkg_prerm')
		sf.close()

		package_stagefile(subdata_file, d)
		#if pkgdatadir2:
		#	bb.copyfile(subdata_file, pkgdatadir2 + "/runtime/%s" % pkg)

		allow_empty = bb.data.getVar('ALLOW_EMPTY_%s' % pkg, d, True)
		if not allow_empty:
			allow_empty = bb.data.getVar('ALLOW_EMPTY', d, True)
		root = "%s/%s" % (pkgdest, pkg)
		os.chdir(root)
		g = glob('*') + glob('.[!.]*')
		if g or allow_empty == "1":
			packagedfile = pkgdatadir + '/runtime/%s.packaged' % pkg
			file(packagedfile, 'w').close()
			package_stagefile(packagedfile, d)
	if pstageactive == "1":
		bb.utils.unlockfile(lf)
}
emit_pkgdata[dirs] = "${PKGDATA_DIR}/runtime"

ldconfig_postinst_fragment() {
if [ x"$D" = "x" ]; then
	if [ -e /etc/ld.so.conf ] ; then
		[ -x /sbin/ldconfig ] && /sbin/ldconfig
	fi
fi
}

SHLIBSDIR = "${STAGING_DIR_HOST}/shlibs"

python package_do_shlibs() {
	import re

	exclude_shlibs = bb.data.getVar('EXCLUDE_FROM_SHLIBS', d, 0)
	if exclude_shlibs:
		bb.debug(1, "not generating shlibs")
		return
		
	lib_re = re.compile("^lib.*\.so")
	libdir_re = re.compile(".*/lib$")

	packages = bb.data.getVar('PACKAGES', d, True)

	workdir = bb.data.getVar('WORKDIR', d, True)

	ver = bb.data.getVar('PKGV', d, True)
	if not ver:
		bb.error("PKGV not defined")
		return

	pkgdest = bb.data.getVar('PKGDEST', d, True)

	shlibs_dir = bb.data.getVar('SHLIBSDIR', d, True)
	bb.mkdirhier(shlibs_dir)

	pstageactive = bb.data.getVar('PSTAGING_ACTIVE', d, True)
	if pstageactive == "1":
		lf = bb.utils.lockfile(bb.data.expand("${STAGING_DIR}/staging.lock", d))

	if bb.data.getVar('PACKAGE_SNAP_LIB_SYMLINKS', d, True) == "1":
		snap_symlinks = True
	else:
		snap_symlinks = False

	if (bb.data.getVar('USE_LDCONFIG', d, True) or "1") == "1":
		use_ldconfig = True
	else:
		use_ldconfig = False

	needed = {}
	private_libs = bb.data.getVar('PRIVATE_LIBS', d, True)
	for pkg in packages.split():
		needs_ldconfig = False
		bb.debug(2, "calculating shlib provides for %s" % pkg)

		pkgver = bb.data.getVar('PKGV_' + pkg, d, True)
		if not pkgver:
			pkgver = bb.data.getVar('PV_' + pkg, d, True)
		if not pkgver:
			pkgver = ver

		needed[pkg] = []
		sonames = list()
		top = os.path.join(pkgdest, pkg)
		renames = []
		for root, dirs, files in os.walk(top):
			for file in files:
				soname = None
				path = os.path.join(root, file)
				if (os.access(path, os.X_OK) or lib_re.match(file)) and not os.path.islink(path):
					cmd = bb.data.getVar('OBJDUMP', d, True) + " -p " + path + " 2>/dev/null"
					cmd = "PATH=\"%s\" %s" % (bb.data.getVar('PATH', d, True), cmd)
					fd = os.popen(cmd)
					lines = fd.readlines()
					fd.close()
					for l in lines:
						m = re.match("\s+NEEDED\s+([^\s]*)", l)
						if m:
							needed[pkg].append(m.group(1))
						m = re.match("\s+SONAME\s+([^\s]*)", l)
						if m:
							this_soname = m.group(1)
							if not this_soname in sonames:
								# if library is private (only used by package) then do not build shlib for it
								if not private_libs or -1 == private_libs.find(this_soname):
									sonames.append(this_soname)
							if libdir_re.match(root):
								needs_ldconfig = True
							if snap_symlinks and (file != soname):
								renames.append((path, os.path.join(root, this_soname)))
		for (old, new) in renames:
			os.rename(old, new)
		shlibs_file = os.path.join(shlibs_dir, pkg + ".list")
		if os.path.exists(shlibs_file):
			os.remove(shlibs_file)
		shver_file = os.path.join(shlibs_dir, pkg + ".ver")
		if os.path.exists(shver_file):
			os.remove(shver_file)
		if len(sonames):
			fd = open(shlibs_file, 'w')
			for s in sonames:
				fd.write(s + '\n')
			fd.close()
			package_stagefile(shlibs_file, d)
			fd = open(shver_file, 'w')
			fd.write(pkgver + '\n')
			fd.close()
			package_stagefile(shver_file, d)
		if needs_ldconfig and use_ldconfig:
			bb.debug(1, 'adding ldconfig call to postinst for %s' % pkg)
			postinst = bb.data.getVar('pkg_postinst_%s' % pkg, d, True) or bb.data.getVar('pkg_postinst', d, True)
			if not postinst:
				postinst = '#!/bin/sh\n'
			postinst += bb.data.getVar('ldconfig_postinst_fragment', d, True)
			bb.data.setVar('pkg_postinst_%s' % pkg, postinst, d)

	if pstageactive == "1":
		bb.utils.unlockfile(lf)

	shlib_provider = {}
	list_re = re.compile('^(.*)\.list$')
	for dir in [shlibs_dir]: 
		if not os.path.exists(dir):
			continue
		for file in os.listdir(dir):
			m = list_re.match(file)
			if m:
				dep_pkg = m.group(1)
				fd = open(os.path.join(dir, file))
				lines = fd.readlines()
				fd.close()
				ver_file = os.path.join(dir, dep_pkg + '.ver')
				lib_ver = None
				if os.path.exists(ver_file):
					fd = open(ver_file)
					lib_ver = fd.readline().rstrip()
					fd.close()
				for l in lines:
					shlib_provider[l.rstrip()] = (dep_pkg, lib_ver)

	assumed_libs = bb.data.getVar('ASSUME_SHLIBS', d, True)
	if assumed_libs:
	    for e in assumed_libs.split():
		l, dep_pkg = e.split(":")
		lib_ver = None
		dep_pkg = dep_pkg.rsplit("_", 1)
		if len(dep_pkg) == 2:
		    lib_ver = dep_pkg[1]
		dep_pkg = dep_pkg[0]
		shlib_provider[l] = (dep_pkg, lib_ver)

	dep_packages = []
	for pkg in packages.split():
		bb.debug(2, "calculating shlib requirements for %s" % pkg)

		deps = list()
		for n in needed[pkg]:
			if n in shlib_provider.keys():
				(dep_pkg, ver_needed) = shlib_provider[n]

				if dep_pkg == pkg:
					continue

				if ver_needed:
					dep = "%s (>= %s)" % (dep_pkg, ver_needed)
				else:
					dep = dep_pkg
				if not dep in deps:
					deps.append(dep)
				if not dep_pkg in dep_packages:
					dep_packages.append(dep_pkg)
					
			else:
				bb.note("Couldn't find shared library provider for %s" % n)

		deps_file = os.path.join(pkgdest, pkg + ".shlibdeps")
		if os.path.exists(deps_file):
			os.remove(deps_file)
		if len(deps):
			fd = open(deps_file, 'w')
			for dep in deps:
				fd.write(dep + '\n')
			fd.close()
}

python package_do_pkgconfig () {
	import re

	packages = bb.data.getVar('PACKAGES', d, True)
	workdir = bb.data.getVar('WORKDIR', d, True)
	pkgdest = bb.data.getVar('PKGDEST', d, True)

	shlibs_dir = bb.data.getVar('SHLIBSDIR', d, True)
	bb.mkdirhier(shlibs_dir)

	pc_re = re.compile('(.*)\.pc$')
	var_re = re.compile('(.*)=(.*)')
	field_re = re.compile('(.*): (.*)')

	pkgconfig_provided = {}
	pkgconfig_needed = {}
	for pkg in packages.split():
		pkgconfig_provided[pkg] = []
		pkgconfig_needed[pkg] = []
		top = os.path.join(pkgdest, pkg)
		for root, dirs, files in os.walk(top):
			for file in files:
				m = pc_re.match(file)
				if m:
					pd = bb.data.init()
					name = m.group(1)
					pkgconfig_provided[pkg].append(name)
					path = os.path.join(root, file)
					if not os.access(path, os.R_OK):
						continue
					f = open(path, 'r')
					lines = f.readlines()
					f.close()
					for l in lines:
						m = var_re.match(l)
						if m:
							name = m.group(1)
							val = m.group(2)
							bb.data.setVar(name, bb.data.expand(val, pd), pd)
							continue
						m = field_re.match(l)
						if m:
							hdr = m.group(1)
							exp = bb.data.expand(m.group(2), pd)
							if hdr == 'Requires':
								pkgconfig_needed[pkg] += exp.replace(',', ' ').split()

	pstageactive = bb.data.getVar('PSTAGING_ACTIVE', d, True)
	if pstageactive == "1":
		lf = bb.utils.lockfile(bb.data.expand("${STAGING_DIR}/staging.lock", d))

	for pkg in packages.split():
		pkgs_file = os.path.join(shlibs_dir, pkg + ".pclist")
		if os.path.exists(pkgs_file):
			os.remove(pkgs_file)
		if pkgconfig_provided[pkg] != []:
			f = open(pkgs_file, 'w')
			for p in pkgconfig_provided[pkg]:
				f.write('%s\n' % p)
			f.close()
			package_stagefile(pkgs_file, d)

	for dir in [shlibs_dir]:
		if not os.path.exists(dir):
			continue
		for file in os.listdir(dir):
			m = re.match('^(.*)\.pclist$', file)
			if m:
				pkg = m.group(1)
				fd = open(os.path.join(dir, file))
				lines = fd.readlines()
				fd.close()
				pkgconfig_provided[pkg] = []
				for l in lines:
					pkgconfig_provided[pkg].append(l.rstrip())

	for pkg in packages.split():
		deps = []
		for n in pkgconfig_needed[pkg]:
			found = False
			for k in pkgconfig_provided.keys():
				if n in pkgconfig_provided[k]:
					if k != pkg and not (k in deps):
						deps.append(k)
					found = True
			if found == False:
				bb.note("couldn't find pkgconfig module '%s' in any package" % n)
		deps_file = os.path.join(pkgdest, pkg + ".pcdeps")
		if os.path.exists(deps_file):
			os.remove(deps_file)
		if len(deps):
			fd = open(deps_file, 'w')
			for dep in deps:
				fd.write(dep + '\n')
			fd.close()
			package_stagefile(deps_file, d)

	if pstageactive == "1":
		bb.utils.unlockfile(lf)
}

python read_shlibdeps () {
	packages = bb.data.getVar('PACKAGES', d, True).split()
	for pkg in packages:
		rdepends = explode_deps(bb.data.getVar('RDEPENDS_' + pkg, d, 0) or bb.data.getVar('RDEPENDS', d, 0) or "")
		for extension in ".shlibdeps", ".pcdeps", ".clilibdeps":
			depsfile = bb.data.expand("${PKGDEST}/" + pkg + extension, d)
			if os.access(depsfile, os.R_OK):
				fd = file(depsfile)
				lines = fd.readlines()
				fd.close()
				for l in lines:
					rdepends.append(l.rstrip())
		bb.data.setVar('RDEPENDS_' + pkg, " " + " ".join(rdepends), d)
}

python package_depchains() {
	"""
	For a given set of prefix and postfix modifiers, make those packages
	RRECOMMENDS on the corresponding packages for its RDEPENDS.

	Example:  If package A depends upon package B, and A's .bb emits an
	A-dev package, this would make A-dev Recommends: B-dev.

	If only one of a given suffix is specified, it will take the RRECOMMENDS
	based on the RDEPENDS of *all* other packages. If more than one of a given 
	suffix is specified, its will only use the RDEPENDS of the single parent 
	package.
	"""

	packages  = bb.data.getVar('PACKAGES', d, True)
	postfixes = (bb.data.getVar('DEPCHAIN_POST', d, True) or '').split()
	prefixes  = (bb.data.getVar('DEPCHAIN_PRE', d, True) or '').split()

	def pkg_adddeprrecs(pkg, base, suffix, getname, depends, d):

		#bb.note('depends for %s is %s' % (base, depends))
		rreclist = explode_deps(bb.data.getVar('RRECOMMENDS_' + pkg, d, True) or bb.data.getVar('RRECOMMENDS', d, True) or "")

		for depend in depends:
			if depend.find('-native') != -1 or depend.find('-cross') != -1 or depend.startswith('virtual/'):
				#bb.note("Skipping %s" % depend)
				continue
			if depend.endswith('-dev'):
				depend = depend.replace('-dev', '')
			if depend.endswith('-dbg'):
				depend = depend.replace('-dbg', '')
			pkgname = getname(depend, suffix)
			#bb.note("Adding %s for %s" % (pkgname, depend))
			if not pkgname in rreclist:
				rreclist.append(pkgname)

		#bb.note('setting: RRECOMMENDS_%s=%s' % (pkg, ' '.join(rreclist)))
		bb.data.setVar('RRECOMMENDS_%s' % pkg, ' '.join(rreclist), d)

	def pkg_addrrecs(pkg, base, suffix, getname, rdepends, d):

		#bb.note('rdepends for %s is %s' % (base, rdepends))
		rreclist = explode_deps(bb.data.getVar('RRECOMMENDS_' + pkg, d, True) or bb.data.getVar('RRECOMMENDS', d, True) or "")

		for depend in rdepends:
			if depend.endswith('-dev'):
				depend = depend.replace('-dev', '')
			if depend.endswith('-dbg'):
				depend = depend.replace('-dbg', '')
			pkgname = getname(depend, suffix)
			if not pkgname in rreclist:
				rreclist.append(pkgname)

		#bb.note('setting: RRECOMMENDS_%s=%s' % (pkg, ' '.join(rreclist)))
		bb.data.setVar('RRECOMMENDS_%s' % pkg, ' '.join(rreclist), d)

	def add_dep(list, dep):
		dep = dep.split(' (')[0].strip()
		if dep not in list:
			list.append(dep)

	depends = []
	for dep in explode_deps(bb.data.getVar('DEPENDS', d, True) or ""):
		add_dep(depends, dep)

	rdepends = []
	for dep in explode_deps(bb.data.getVar('RDEPENDS', d, True) or ""):
		add_dep(rdepends, dep)

	for pkg in packages.split():
		for dep in explode_deps(bb.data.getVar('RDEPENDS_' + pkg, d, True) or ""):
			add_dep(rdepends, dep)

	#bb.note('rdepends is %s' % rdepends)

	def post_getname(name, suffix):
		return '%s%s' % (name, suffix)
	def pre_getname(name, suffix):
		return '%s%s' % (suffix, name)

	pkgs = {}
	for pkg in packages.split():
		for postfix in postfixes:
			if pkg.endswith(postfix):
				if not postfix in pkgs:
					pkgs[postfix] = {}
				pkgs[postfix][pkg] = (pkg[:-len(postfix)], post_getname)

		for prefix in prefixes:
			if pkg.startswith(prefix):
				if not prefix in pkgs:
					pkgs[prefix] = {}
				pkgs[prefix][pkg] = (pkg[:-len(prefix)], pre_getname)

	for suffix in pkgs:
		for pkg in pkgs[suffix]:
			(base, func) = pkgs[suffix][pkg]
			if suffix == "-dev" and not pkg.startswith("kernel-module-"):
				pkg_adddeprrecs(pkg, base, suffix, func, depends, d)
			if len(pkgs[suffix]) == 1:
				pkg_addrrecs(pkg, base, suffix, func, rdepends, d)
			else:
				rdeps = []
				for dep in explode_deps(bb.data.getVar('RDEPENDS_' + base, d, True) or bb.data.getVar('RDEPENDS', d, True) or ""):
					add_dep(rdeps, dep)
				pkg_addrrecs(pkg, base, suffix, func, rdeps, d)
}

PACKAGE_PREPROCESS_FUNCS ?= ""
PACKAGEFUNCS ?= "perform_packagecopy \
                ${PACKAGE_PREPROCESS_FUNCS} \
		package_do_split_locales \
		populate_packages \
		package_do_shlibs \
		package_do_pkgconfig \
		read_shlibdeps \
		package_depchains \
		emit_pkgdata"

def package_run_hooks(f, d):
	import bb, os
	staging = bb.data.getVar('PKGDATA_DIR', d, True)
	dn = os.path.join(staging, 'hooks', f)
	if os.access(dn, os.R_OK):
		for f in os.listdir(dn):
			fn = os.path.join(dn, f)
			fp = open(fn, 'r')
			line = 0
			for l in fp.readlines():
				l = l.rstrip()
				bb.parse.parse_py.BBHandler.feeder(line, l, fn, os.path.basename(fn), d)
				line += 1
			fp.close()
	                anonqueue = bb.data.getVar("__anonqueue", d, True) or []
        	        body = [x['content'] for x in anonqueue]
            	        flag = { 'python' : 1, 'func' : 1 }
            	        bb.data.setVar("__anonfunc", "\n".join(body), d)
         		bb.data.setVarFlags("__anonfunc", flag, d)
		        try:
                		t = bb.data.getVar('T', d)
           			bb.data.setVar('T', '${TMPDIR}/', d)
                		bb.build.exec_func("__anonfunc", d)
                		bb.data.delVar('T', d)
                		if t:
                    			bb.data.setVar('T', t, d)
		        except Exception, e:
                		bb.msg.debug(1, bb.msg.domain.Parsing, "Exception when executing anonymous function: %s" % e)
                		raise
            		bb.data.delVar("__anonqueue", d)
            		bb.data.delVar("__anonfunc", d)

python package_do_package () {
	packages = (bb.data.getVar('PACKAGES', d, True) or "").split()
	if len(packages) < 1:
		bb.debug(1, "No packages to build, skipping do_package")
		return

	workdir = bb.data.getVar('WORKDIR', d, True)
	outdir = bb.data.getVar('DEPLOY_DIR', d, True)
	dest = bb.data.getVar('D', d, True)
	dvar = bb.data.getVar('PKGD', d, True)
	pn = bb.data.getVar('PN', d, True)

	if not workdir or not outdir or not dest or not dvar or not pn or not packages:
		bb.error("WORKDIR, DEPLOY_DIR, D, PN and PKGD all must be defined, unable to package")
		return

	for f in (bb.data.getVar('PACKAGEFUNCS', d, True) or '').split():
		bb.build.exec_func(f, d)
		package_run_hooks(f, d)
}
do_package[dirs] = "${D}"
addtask package before do_build after do_install

# Dummy task to mark when all packaging is complete
do_package_write () {
	:
}
addtask package_write before do_build after do_package

EXPORT_FUNCTIONS do_package do_package_write

#
# Helper functions for the package writing classes
#

python package_mapping_rename_hook () {
	"""
	Rewrite variables to account for package renaming in things
	like debian.bbclass or manual PKG variable name changes
	"""
	runtime_mapping_rename("RDEPENDS", d)
	runtime_mapping_rename("RRECOMMENDS", d)
	runtime_mapping_rename("RSUGGESTS", d)
	runtime_mapping_rename("RPROVIDES", d)
	runtime_mapping_rename("RREPLACES", d)
	runtime_mapping_rename("RCONFLICTS", d)
}

EXPORT_FUNCTIONS mapping_rename_hook
