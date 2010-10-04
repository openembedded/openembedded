require libtool_${PV}.bb

PR = "${INC_PR}.1"
SRC_URI_append = " file://cross_compile.patch"

inherit sdk

do_install () {
	install -d ${D}${bindir}/
	install -m 0755 libtool ${D}${bindir}/
	install -m 0755 libtool ${D}${bindir}/${HOST_SYS}-libtool
	install -m 0755 libtoolize ${D}${bindir}/

	install -d ${D}${libdir}/
	oe_libinstall -a -so -C libltdl libltdl ${D}${libdir}

	install -d ${D}${includedir}/
	install -m 0644 libltdl/ltdl.h ${D}${includedir}

	install -d ${D}${datadir}/libtool/config/
	install -c ${S}/libltdl/config/config.guess ${D}${datadir}/libtool/
	install -c ${S}/libltdl/config/config.sub ${D}${datadir}/libtool/
	install -c -m 0644 ${S}/libltdl/config/ltmain.sh ${D}${datadir}/libtool/config/

	install -d ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltoptions.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltversion.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/ltsugar.m4 ${D}${datadir}/aclocal/
	install -c -m 0644 ${S}/libltdl/m4/lt~obsolete.m4 ${D}${datadir}/aclocal/
}

NATIVE_INSTALL_WORKS = "1"
