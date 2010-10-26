BB_DEFAULT_TASK ?= "build"

inherit patch
inherit staging
inherit packaged-staging

inherit packagedata
inherit mirrors
inherit utils
inherit utility-tasks
inherit metadata_scm

OE_IMPORTS += "oe.path oe.utils oe.packagegroup sys os time"

python oe_import () {
    if isinstance(e, bb.event.ConfigParsed):
        import os, sys
        bbpath = e.data.getVar("BBPATH", True).split(":")
        sys.path[0:0] = [os.path.join(dir, "lib") for dir in bbpath]

        def inject(name, value):
            """Make a python object accessible from the metadata"""
            if hasattr(bb.utils, "_context"):
                bb.utils._context[name] = value
            else:
                __builtins__[name] = value

        for toimport in e.data.getVar("OE_IMPORTS", True).split():
            imported = __import__(toimport)
            inject(toimport.split(".", 1)[0], imported)
}

addhandler oe_import

die() {
	oefatal "$*"
}

oenote() {
	echo "NOTE:" "$*"
}

oewarn() {
	echo "WARNING:" "$*"
}

oefatal() {
	echo "FATAL:" "$*"
	exit 1
}

oe_runmake() {
	oenote ${MAKE} ${EXTRA_OEMAKE} "$@"
	${MAKE} ${EXTRA_OEMAKE} "$@" || die "oe_runmake failed"
}

def base_deps(d):
	#
	# Ideally this will check a flag so we will operate properly in
	# the case where host == build == target, for now we don't work in
	# that case though.
	#
	deps = "coreutils-native"
	if bb.data.getVar('PN', d, True) in ("shasum-native", "stagemanager-native",
	                                     "coreutils-native"):
		deps = ""

	# INHIBIT_DEFAULT_DEPS doesn't apply to the patch command.  Whether or  not
	# we need that built is the responsibility of the patch function / class, not
	# the application.
	if not bb.data.getVar('INHIBIT_DEFAULT_DEPS', d):
		if (bb.data.getVar('HOST_SYS', d, 1) !=
	     	    bb.data.getVar('BUILD_SYS', d, 1)):
			deps += " virtual/${TARGET_PREFIX}gcc virtual/libc "
		elif bb.data.inherits_class('native', d) and \
				bb.data.getVar('PN', d, True) not in \
				("linux-libc-headers-native", "quilt-native",
				 "unifdef-native", "shasum-native",
				 "stagemanager-native", "coreutils-native"):
			deps += " linux-libc-headers-native"
	return deps

DEPENDS_prepend="${@base_deps(d)} "
DEPENDS_virtclass-native_prepend="${@base_deps(d)} "
DEPENDS_virtclass-nativesdk_prepend="${@base_deps(d)} "


SCENEFUNCS += "base_scenefunction"

python base_scenefunction () {
	stamp = bb.data.getVar('STAMP', d, 1) + ".needclean"
	if os.path.exists(stamp):
	        bb.build.exec_func("do_clean", d)
}

python base_do_setscene () {
        for f in (bb.data.getVar('SCENEFUNCS', d, 1) or '').split():
                bb.build.exec_func(f, d)
	if not os.path.exists(bb.data.getVar('STAMP', d, 1) + ".do_setscene"):
		bb.build.make_stamp("do_setscene", d)
}
do_setscene[selfstamp] = "1"
addtask setscene before do_fetch

addtask fetch
do_fetch[dirs] = "${DL_DIR}"
python base_do_fetch() {
	import sys

	localdata = bb.data.createCopy(d)
	bb.data.update_data(localdata)

	src_uri = bb.data.getVar('SRC_URI', localdata, 1)
	if not src_uri:
		return 1

	try:
		bb.fetch.init(src_uri.split(),d)
	except bb.fetch.NoMethodError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("No method: %s" % value)
	except bb.MalformedUrl:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Malformed URL: %s" % value)

	try:
		bb.fetch.go(localdata)
	except bb.fetch.MissingParameterError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Missing parameters: %s" % value)
	except bb.fetch.FetchError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Fetch failed: %s" % value)
	except bb.fetch.MD5SumError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("MD5  failed: %s" % value)
	except:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Unknown fetch Error: %s" % value)


	pv = bb.data.getVar('PV', d, True)
	pn = bb.data.getVar('PN', d, True)

	# Check each URI
	first_uri = True
	for url in src_uri.split():
		localpath = bb.data.expand(bb.fetch.localpath(url, localdata), localdata)
		(type,host,path,_,_,params) = bb.decodeurl(url)
		uri = "%s://%s%s" % (type,host,path)
		try:
			if type in [ "http", "https", "ftp", "ftps" ]:
				# We provide a default shortcut of plain [] for the first fetch uri
				# Explicit names in any uri overrides this default.
				if not "name" in params and first_uri:
					first_uri = False
					params["name"] = ""
				if not base_chk_file(pn, pv, uri, localpath, params, d):
					if not bb.data.getVar("OE_ALLOW_INSECURE_DOWNLOADS", d, True):
						bb.fatal("%s-%s: %s cannot check archive integrity" % (pn,pv,uri))
					else:
						bb.note("%s-%s: %s cannot check archive integrity" % (pn,pv,uri))
		except Exception:
			raise bb.build.FuncFailed("Checksum of '%s' failed" % uri)
}

def oe_unpack(d, local, urldata):
    from oe.unpack import unpack_file, is_patch, UnpackError
    if is_patch(local, urldata.parm):
        return

    subdirs = []
    if "subdir" in urldata.parm:
        subdirs.append(urldata.parm["subdir"])

    if urldata.type == "file":
        if not urldata.host:
            urlpath = urldata.path
        else:
            urlpath = "%s%s" % (urldata.host, urldata.path)

        if not os.path.isabs(urlpath):
            subdirs.append(os.path.dirname(urlpath))

    workdir = d.getVar("WORKDIR", True)
    if subdirs:
        destdir = oe.path.join(workdir, *subdirs)
        bb.mkdirhier(destdir)
    else:
        destdir = workdir
    dos = urldata.parm.get("dos")

    bb.note("Unpacking %s to %s/" % (base_path_out(local, d),
                                     base_path_out(destdir, d)))
    try:
        unpack_file(local, destdir, env={"PATH": d.getVar("PATH", True)}, dos=dos)
    except UnpackError, exc:
        bb.fatal(str(exc))

addtask unpack after do_fetch
do_unpack[dirs] = "${WORKDIR}"
python base_do_unpack() {
    from glob import glob

    src_uri = d.getVar("SRC_URI", True)
    if not src_uri:
        return
    srcurldata = bb.fetch.init(src_uri.split(), d, True)
    filespath = d.getVar("FILESPATH", True).split(":")

    for url in src_uri.split():
        urldata = srcurldata[url]
        if urldata.type == "file" and "*" in urldata.path:
            # The fetch code doesn't know how to handle globs, so
            # we need to handle the local bits ourselves
            for path in filespath:
                srcdir = oe.path.join(path, urldata.host,
                                      os.path.dirname(urldata.path))
                if os.path.exists(srcdir):
                    break
            else:
                bb.fatal("Unable to locate files for %s" % url)

            for filename in glob(oe.path.join(srcdir,
                                              os.path.basename(urldata.path))):
                oe_unpack(d, filename, urldata)
        else:
            local = urldata.localpath
            if not local:
                raise bb.build.FuncFailed('Unable to locate local file for %s' % url)

            oe_unpack(d, local, urldata)
}

addhandler base_eventhandler
python base_eventhandler() {
	from bb import note, error, data
	from bb.event import getName


	name = getName(e)
	if name == "TaskCompleted":
		msg = "package %s: task %s is complete." % (data.getVar("PF", e.data, 1), e.task)
	elif name == "UnsatisfiedDep":
		msg = "package %s: dependency %s %s" % (e.pkg, e.dep, name[:-3].lower())
	else:
		return

	# Only need to output when using 1.8 or lower, the UI code handles it
	# otherwise
	if (int(bb.__version__.split(".")[0]) <= 1 and int(bb.__version__.split(".")[1]) <= 8):
		if msg:
			note(msg)

	if name.startswith("BuildStarted"):
		bb.data.setVar( 'BB_VERSION', bb.__version__, e.data )
		statusvars = bb.data.getVar("BUILDCFG_VARS", e.data, 1).split()
		statuslines = ["%-17s = \"%s\"" % (i, bb.data.getVar(i, e.data, 1) or '') for i in statusvars]
		statusmsg = "\n%s\n%s\n" % (bb.data.getVar("BUILDCFG_HEADER", e.data, 1), "\n".join(statuslines))
		print statusmsg

		needed_vars = bb.data.getVar("BUILDCFG_NEEDEDVARS", e.data, 1).split()
		pesteruser = []
		for v in needed_vars:
			val = bb.data.getVar(v, e.data, 1)
			if not val or val == 'INVALID':
				pesteruser.append(v)
		if pesteruser:
			bb.fatal('The following variable(s) were not set: %s\nPlease set them directly, or choose a MACHINE or DISTRO that sets them.' % ', '.join(pesteruser))

	#
	# Handle removing stamps for 'rebuild' task
	#
	if name.startswith("StampUpdate"):
		for (fn, task) in e.targets:
			#print "%s %s" % (task, fn)
			if task == "do_rebuild":
				dir = "%s.*" % e.stampPrefix[fn]
				bb.note("Removing stamps: " + dir)
				os.system('rm -f '+ dir)
				os.system('touch ' + e.stampPrefix[fn] + '.needclean')

	if not data in e.__dict__:
		return

	log = data.getVar("EVENTLOG", e.data, 1)
	if log:
		logfile = file(log, "a")
		logfile.write("%s\n" % msg)
		logfile.close()
}

addtask configure after do_unpack do_patch
do_configure[dirs] = "${S} ${B}"
do_configure[deptask] = "do_populate_sysroot"
base_do_configure() {
	:
}

addtask compile after do_configure
do_compile[dirs] = "${S} ${B}"
base_do_compile() {
	if [ -e Makefile -o -e makefile -o -e GNUmakefile ]; then
		oe_runmake || die "make failed"
	else
		oenote "nothing to compile"
	fi
}

addtask install after do_compile
do_install[dirs] = "${D} ${S} ${B}"
# Remove and re-create ${D} so that is it guaranteed to be empty
do_install[cleandirs] = "${D}"

base_do_install() {
	:
}

base_do_package() {
	:
}

addtask build
do_build = ""
do_build[func] = "1"

python () {
    import exceptions

    source_mirror_fetch = bb.data.getVar('SOURCE_MIRROR_FETCH', d, 0)
    if not source_mirror_fetch:
        need_host = bb.data.getVar('COMPATIBLE_HOST', d, 1)
        if need_host:
            import re
            this_host = bb.data.getVar('HOST_SYS', d, 1)
            if not re.match(need_host, this_host):
                raise bb.parse.SkipPackage("incompatible with host %s" % this_host)

        need_machine = bb.data.getVar('COMPATIBLE_MACHINE', d, 1)
        if need_machine:
            import re
            this_machine = bb.data.getVar('MACHINE', d, 1)
            if this_machine and not re.match(need_machine, this_machine):
                this_soc_family = bb.data.getVar('SOC_FAMILY', d, 1)
                if (this_soc_family and not re.match(need_machine, this_soc_family)) or not this_soc_family:
                    raise bb.parse.SkipPackage("incompatible with machine %s" % this_machine)

        need_target = bb.data.getVar('COMPATIBLE_TARGET_SYS', d, 1)
        if need_target:
            import re
            this_target = bb.data.getVar('TARGET_SYS', d, 1)
            if this_target and not re.match(need_target, this_target):
                raise bb.parse.SkipPackage("incompatible with target system %s" % this_target)

    pn = bb.data.getVar('PN', d, 1)

    # OBSOLETE in bitbake 1.7.4
    srcdate = bb.data.getVar('SRCDATE_%s' % pn, d, 1)
    if srcdate != None:
        bb.data.setVar('SRCDATE', srcdate, d)

    use_nls = bb.data.getVar('USE_NLS_%s' % pn, d, 1)
    if use_nls != None:
        bb.data.setVar('USE_NLS', use_nls, d)

    setup_checksum_deps(d)

    # Git packages should DEPEND on git-native
    srcuri = bb.data.getVar('SRC_URI', d, 1)
    if "git://" in srcuri:
        depends = bb.data.getVarFlag('do_fetch', 'depends', d) or ""
        depends = depends + " git-native:do_populate_sysroot"
        bb.data.setVarFlag('do_fetch', 'depends', depends, d)

    if "hg://" in srcuri:
        depends = bb.data.getVarFlag('do_fetch', 'depends', d) or ""
        depends = depends + " mercurial-native:do_populate_sysroot"
        bb.data.setVarFlag('do_fetch', 'depends', depends, d)

    # unzip-native should already be staged before unpacking ZIP recipes
    need_unzip = bb.data.getVar('NEED_UNZIP_FOR_UNPACK', d, 1)
    src_uri = bb.data.getVar('SRC_URI', d, 1)

    if ".zip" in src_uri or need_unzip == "1":
        depends = bb.data.getVarFlag('do_unpack', 'depends', d) or ""
        depends = depends + " unzip-native:do_populate_sysroot"
        bb.data.setVarFlag('do_unpack', 'depends', depends, d)

    if ".lz" in src_uri:
        depends = bb.data.getVarFlag('do_unpack', 'depends', d) or ""
        depends = depends + " lzip-native:do_populate_sysroot"
        bb.data.setVarFlag('do_unpack', 'depends', depends, d)

    # 'multimachine' handling
    mach_arch = bb.data.getVar('MACHINE_ARCH', d, 1)
    pkg_arch = bb.data.getVar('PACKAGE_ARCH', d, 1)

    if (pkg_arch == mach_arch):
        # Already machine specific - nothing further to do
        return

    #
    # We always try to scan SRC_URI for urls with machine overrides
    # unless the package sets SRC_URI_OVERRIDES_PACKAGE_ARCH=0
    #
    override = bb.data.getVar('SRC_URI_OVERRIDES_PACKAGE_ARCH', d, 1)
    if override != '0' and is_machine_specific(d):
        bb.data.setVar('PACKAGE_ARCH', "${MACHINE_ARCH}", d)
        bb.data.setVar('MULTIMACH_ARCH', mach_arch, d)
        return

    multiarch = pkg_arch

    packages = bb.data.getVar('PACKAGES', d, 1).split()
    for pkg in packages:
        pkgarch = bb.data.getVar("PACKAGE_ARCH_%s" % pkg, d, 1)

        # We could look for != PACKAGE_ARCH here but how to choose
        # if multiple differences are present?
        # Look through PACKAGE_ARCHS for the priority order?
        if pkgarch and pkgarch == mach_arch:
            multiarch = mach_arch
            break

    bb.data.setVar('MULTIMACH_ARCH', multiarch, d)
}

EXPORT_FUNCTIONS do_setscene do_fetch do_unpack do_configure do_compile do_install do_package
