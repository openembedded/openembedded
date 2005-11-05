SECTION = "libs"
DESCRIPTION = "giblib is a utility library that incorporates doubly linked \
lists, some string functions, and a wrapper for imlib2."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "BSD"
DEPENDS = "imlib2"

SRC_URI = "http://linuxbrit.co.uk/downloads/giblib-${PV}.tar.gz \
	   file://binconfig.patch;patch=1"
S = "${WORKDIR}/giblib-${PV}"

inherit autotools pkgconfig binconfig

do_stage () {
	autotools_stage_includes
	oe_libinstall -a -so -C giblib libgiblib ${STAGING_LIBDIR}
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/giblib-config"
