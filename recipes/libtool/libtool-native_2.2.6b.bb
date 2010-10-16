require libtool_${PV}.bb
PR = "${INC_PR}.1"

SRC_URI += "\
  file://cross_compile.patch \
  file://prefix.patch \
"

inherit native

do_configure_prepend () {
	# Remove any existing libtool m4 since old stale versions would break
	# any upgrade
	rm -f ${D}${datadir}/aclocal/libtool.m4
	rm -f ${D}${datadir}/aclocal/lt*.m4
}

do_install () {
	install -d ${D}${bindir}/
	install -d ${D}${includedir}/
	install -m 0755 ${HOST_SYS}-libtool ${D}${bindir}/${HOST_SYS}-libtool
	install -m 0755 libtoolize ${D}${bindir}/libtoolize
	oe_libinstall -a -so -C libltdl libltdl ${D}${libdir}
	install -m 0644 libltdl/ltdl.h ${D}${includedir}/
	install -d ${D}${includedir}/libltdl/
	install -m 0644 libltdl/libltdl/*.h ${D}${includedir}/libltdl/
	install -d ${D}${datadir}/libtool/config/ ${D}${datadir}/aclocal/
	install -c ${S}/libltdl/config/config.guess ${D}${datadir}/libtool/
	install -c ${S}/libltdl/config/config.sub ${D}${datadir}/libtool/
	for i in config.guess config.sub compile depcomp general.m4sh getopt.m4sh install-sh ltmain.m4sh ltmain.sh mdate-sh missing mkstamp ; do \
		install -c -m 0644 ${S}/libltdl/config/$i ${D}${datadir}/libtool/config/
	done
	install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltoptions.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltversion.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltsugar.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/lt~obsolete.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/argz.m4 ${D}${datadir}/aclocal/

	install -d ${D}${datadir}/libtool/libltdl
	cp -pfPR  ${S}/libltdl/* ${D}${datadir}/libtool/libltdl/
}

