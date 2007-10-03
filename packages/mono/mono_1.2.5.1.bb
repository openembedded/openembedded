require mono_1.2.5.inc

DEPENDS = "mono-native mono-mcs-intermediate glib-2.0 perl-native"

PR = "r2"

SRC_URI += "file://configure.patch;patch=1"

# Per http://www.mono-project.com/Mono:ARM
EXTRA_OECONF += " --disable-mcs-build "
# Instead, get the mcs tree from a different build (see mono-mcs-intermediate)

do_install_prepend() {
	install -d ${D}
	pushd ${D}
	tar -xzf ${STAGING_DIR}/share/mono-mcs/mono-mcs-${PV}.tar.gz
	popd
}

do_install_append() {
	# mono-mcs-intermediate builds and installs jay (a Yacc for Java and C#),
	# however, jay is not being cross-compiled and thus only
	# available for the buildhost architecture, so remove it
	# entirely
	pushd ${D}
	rm -rf ./usr/share/man/man1/jay.1 ./usr/share/jay \
	    ./usr/share/jay/README.jay \
	    ./usr/bin/jay
	popd

	# Not packaged with the default rules and apparently
	# not used for anything
	rm -rf ${D}${datadir}/mono-1.0/mono/cil/cil-opcodes.xml
}

inherit mono
PACKAGES = "${@" ".join([e["name"] for e in mono_get_file_table(bb.data.getVar('PV', d, 1), d) if e.has_key("name")])}"

FILES_mono-doc_append = " /usr/share/libgc-mono/ "

FILES_mono = "" # Apparently this gets ignored, so I'm setting it again below
ALLOW_EMPTY_mono = "1"
RDEPENDS_mono = "mono-common mono-jit"

FILES_mono-runtime = ""
ALLOW_EMPTY_mono-runtime = "1"
RDEPENDS_mono-runtime = "mono-jit mono-gac"

RDEPENDS_mono-jit = "mono-common"

FILES_libmono-dev = "/usr/lib/libmono.la /usr/lib/libmono-profiler-cov.la /usr/lib/libmono-profiler-aot.la \
	/usr/lib/libMonoPosixHelper.la /usr/lib/libMonoSupportW.la"
FILES_libmono-dbg = "/usr/lib/.debug/libmono*.so.* /usr/lib/.debug/libikvm-native.so \
	/usr/lib/.debug/libMonoPosixHelper.so /usr/lib/.debug/libMonoSupportW.so"

python populate_packages_prepend () {
	def fillin_packages():
		# A lot of this code can probably be replaced with less code and some
		# calls to do_split_packages
		import bb, sys, os, glob, commands
		
		PV = bb.data.getVar('PV', d, 1)
		
		file_table = mono_get_file_table(PV, d)
		packages_to_add = []
		
		D = bb.data.getVar('D', d, 1)
		if not D: return
		D = D + "/"
		
		def classify_files(files):
			normal, dev, dbg, doc = [], [], [], []
			for filename in files:
				if filename.endswith(".mdb"):
					dbg.append(filename)
				elif os.path.basename( os.path.dirname( filename ) ) == ".debug":
					dbg.append(filename)
				elif filename.endswith(".pc"):
					dev.append(filename)
				else:
					normal.append(filename)
			return normal, dev, dbg, doc
		
		def will_strip(filename):
			# From package.bbclass function runstrip
			pathprefix = "export PATH=%s; " % bb.data.getVar('PATH', d, 1)
			ret, result = commands.getstatusoutput("%sfile '%s'" % (pathprefix, filename))
			if "not stripped" in result:
				return True
			else:
				return False

		def append(name, value):
			oldvalue = bb.data.getVar(name, d, 1) or ""
			newvalue = " ".join([oldvalue, value])
			bb.data.setVar(name, newvalue, d)
		
		already_covered = []
		for package in file_table:
			pn = package["name"]
			if package.has_key("patterns"):
				files = []
				for pattern in package["patterns"]:
					matching = glob.glob( D + pattern )
					for filename in matching:
						if os.path.isdir(filename):
							for dirpath, dirnames, filenames in os.walk(filename):
								for f in filenames:
									debugname = os.path.join(dirpath, ".debug", f)
									fullname =  os.path.join(dirpath, f)
									files.append(fullname)
									if will_strip(fullname):
										files.append(debugname)
						else:
						    files.append(filename)
				
				# Remove the D prefix
				files = [ e[len(D):] for e in files ]
				
				# Remove files that have already been placed in other packages
				files = [ e for e in files if not e in already_covered ]
				already_covered.extend( files )
				
				if pn.endswith("-dev") or pn.endswith("-dbg") or pn.endswith("-doc"):
					normal, dev, dbg, doc = files, [], [], []
				else:
					normal, dev, dbg, doc = classify_files(files)
				
				for extension, filelist in [ ("",normal), ("-dev", dev), ("-dbg", dbg), ("-doc", doc)]:
					if len(filelist) > 0:
						packagename = pn + extension
						append("FILES_%s" % packagename, " ".join(filelist))
						bb.debug(2, "%s\n\t%s" %( packagename, "\n\t".join( filelist ) ))
						if not packagename in packages_to_add:
							packages_to_add.append(packagename)
				
			else:
				packages_to_add.append(pn)
		
		# mono is just a stub package
		bb.data.setVar("FILES_mono", "", d)
		
		bb.data.setVar("PACKAGES", " ".join(packages_to_add), d)
	fillin_packages()
}
