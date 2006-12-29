DESCRIPTION = "tslib is a plugin-based flexible touchscreen access library."
HOMEPAGE = "http://tslib.berlios.de/"
AUTHOR = "Russell King w/ plugins by Chris Larson et. al."
SECTION = "base"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://download.berlios.de/tslib/tslib-1.0.tar.bz2 \
	   file://ts.conf \
	   file://ts.conf-h3600 file://ts.conf-h3600-2.4 file://ts.conf-h6300 \
	   file://ts.conf-corgi file://ts.conf-corgi-2.4 \
	   file://ts.conf-simpad file://ts.conf-simpad-2.4 \
	   file://tslib.sh"
SRC_URI_append_poodle += "file://ts-2.4.conf file://ts-2.6.conf"
SRC_URI_append_collie += "file://ts-2.4.conf file://ts-2.6.conf"


inherit autotools pkgconfig

EXTRA_OECONF        = "--enable-shared"

do_stage() {
	oe_libinstall -so -C src libts-0.0 ${STAGING_LIBDIR}
	ln -sf libts-0.0.so ${STAGING_LIBDIR}/libts.so
	install -m 0644 src/tslib.h ${STAGING_INCDIR}/
	install -m 0644 src/tslib-private.h ${STAGING_INCDIR}/
}

do_install_prepend() {
	install -m 0644 ${WORKDIR}/ts.conf ${S}/etc/ts.conf
}

do_install_append() {
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${WORKDIR}/tslib.sh ${D}${sysconfdir}/profile.d/
	case ${MACHINE} in
	h3600 | h3900 | h1940 | h6300 | h2200 | ipaq-pxa270)
		install -d ${D}${datadir}/tslib
		for f in ts.conf-h3600 ts.conf-h3600-2.4 ts.conf-h6300; do
			install -m 0644 ${WORKDIR}/$f ${D}${datadir}/tslib/
		done
		rm -f ${D}${sysconfdir}/ts.conf
		;;
	c7x0 | spitz | akita | tosa )
		install -d ${D}${datadir}/tslib
		for f in ts.conf-corgi ts.conf-corgi-2.4; do
			install -m 0644 ${WORKDIR}/$f ${D}${datadir}/tslib/
		done
		rm -f ${D}${sysconfdir}/ts.conf
		;;
	poodle | collie )
		install -d ${D}${datadir}/tslib
		install -m 0644 ${WORKDIR}/ts-2.*.conf ${D}${datadir}/tslib/
		rm -f ${D}${sysconfdir}/ts.conf
		;;
	simpad )
		install -d ${D}${datadir}/tslib
		for f in ts.conf-simpad ts.conf-simpad-2.4; do
			install -m 0644 ${WORKDIR}/$f ${D}${datadir}/tslib/
		done
		rm -f ${D}${sysconfdir}/ts.conf
		;;
	*)
		;;
	esac
}

SRC_URI_OVERRIDES_PACKAGE_ARCH = "0"

PACKAGE_ARCH_tslib-conf = "${MACHINE_ARCH}"

PACKAGES =+ "tslib-conf libts-dev tslib-tests tslib-calibrate"
DEBIAN_NOAUTONAME_tslib-conf = "1"
DEBIAN_NOAUTONAME_tslib-tests = "1"
DEBIAN_NOAUTONAME_tslib-calibrate = "1"

RDEPENDS_${PN} = "tslib-conf"


FILES_tslib-conf = "${sysconfdir}/ts.conf ${sysconfdir}/profile.d/tslib.sh ${datadir}/tslib"
FILES_${PN} = "${libdir}/*.so.* ${libdir}/ts/*.so*"
FILES_libts-dev = "${FILES_tslib-dev}"
FILES_tslib-calibrate += "${bindir}/ts_calibrate"
FILES_tslib-tests = "${bindir}/ts_harvest ${bindir}/ts_print ${bindir}/ts_print_raw ${bindir}/ts_test"
