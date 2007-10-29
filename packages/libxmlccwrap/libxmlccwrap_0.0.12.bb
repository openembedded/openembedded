DESCRIPTION = "A small libxml2 c++ wrapper"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"
DEPENDS = "libxml2"
RDEPENDS = "libxml2"

SRC_URI = "http://www.ant.uni-bremen.de/whomes/rinas/libxmlccwrap/download/libxmlccwrap-${PV}.tar.gz \
	   file://dont_build_unneeded.patch;patch=1;pnum=1 \
	   file://disable_libxslt.patch;patch=1;pnum=1 \
	   file://fix_assignment_operator.patch;patch=1;pnum=1"

inherit autotools

FILES_${PN} = "/usr/lib/*.so*"
FILES_${PN}-dev = "/usr/include/*.h"

do_stage () {
	install -d ${STAGING_INCDIR}/xmlccwrap
	install ${S}/xmlccwrap/*.h ${STAGING_INCDIR}/xmlccwrap
	install ${S}/xmlccwrap/.libs/libxmlccwrap-${PV}.so ${STAGING_LIBDIR}
	ln -sf ${STAGING_LIBDIR}/libxmlccwrap-${PV}.so ${STAGING_LIBDIR}/libxmlccwrap.so
}
