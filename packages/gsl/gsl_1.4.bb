DESCRIPTION = "GNU Scientific Library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.mirror.ac.uk/sites/sources.redhat.com/pub/gsl/gsl-${PV}.tar.gz"

inherit autotools pkgconfig binconfig

LEAD_SONAME = "libgsl.so"

do_stage() {
	oe_runmake DESTDIR=${S}/.install install
	oe_libinstall -so -C cblas/.libs/ libgslcblas ${STAGING_LIBDIR}
	oe_libinstall -so -C .libs/ libgsl ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/gsl
	install -m 0644 .install${includedir}/gsl/* ${STAGING_INCDIR}/gsl
}
