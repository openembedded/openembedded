DESCRIPTION = "Ecore is the core event abstraction layer for the enlightenment \
foundation libraries. It makes makes doing selections, drag and drop, event loops, \
timeouts and idle handlers fast, optimized, and convenient."
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"
PRIORITY = "optional"
LEAD_SONAME = "libecore.so"
LICENSE = "MIT"
PV = "${CVSDATE}"
DEPENDS = "edb eet evas freetype edb-native"
PR = "r5"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/ecore \
           file://no-x-test.patch;patch=1"
S = "${WORKDIR}/ecore"

inherit autotools binconfig

EXTRA_OECONF = "--enable-ecore-fb \
		--enable-ecore-job \
		--enable-ecore-evas-fb \
		--disable-ecore-evas-x \
		--disable-ecore-evas-gl \
		--enable-ecore-con \
		--enable-ecore-ipc \
		--enable-ecore-txt \
		--disable-ecore-x \
		--enable-ecore-config \
		--disable-openssl"

parts = "Ecore Ecore_Job \
	 Ecore_Txt Ecore_Fb Ecore_Con \
	 Ecore_Ipc Ecore_Evas Ecore_Config"

do_stage () {
	for p in ${parts}; do
		dir=`echo $p|tr A-Z a-z`
		install -m 0644 ${S}/src/lib/$dir/$p.h ${STAGING_INCDIR}/
		oe_libinstall -C src/lib/$dir lib$dir ${STAGING_LIBDIR}/
	done
	install -m 0644 ${S}/src/lib/ecore/Ecore_Data.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/ecore.m4 ${STAGING_DATADIR}/aclocal/
}

PACKAGES += "ecore-examples"

FILES_${PN} = "${libdir}/libecore*.so* ${libdir}/ecore_config_ipc_ecore.so"
FILES_${PN}-dev += "${bindir}/ecore-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/ecore_test ${bindir}/ecore_evas_test ${datadir}"
