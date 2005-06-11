DESCRIPTION = "Ecore is the core event abstraction layer for the enlightenment \
foundation libraries. It makes makes doing selections, drag and drop, event loops, \
timeouts and idle handlers fast, optimized, and convenient."
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"
PRIORITY = "optional"
LEAD_SONAME = "libecore.so"
PROVIDES = "virtual/ecore"
LICENSE = "MIT"
DEPENDS = "edb eet virtual/evas freetype edb-native"

SRC_URI = "http://enlightenment.freedesktop.org/files/ecore-${PV}.tar.gz \
           file://fix-configure.patch;patch=1"
S = "${WORKDIR}/ecore-${PV}"

inherit autotools binconfig

EXTRA_OECONF = "<override me>"

parts = "<override me>"

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
