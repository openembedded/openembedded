DESCRIPTION = "Epsilon is a flexable and powerful image thumbnailing library \
that is complient with the freedesktop.org Thumbnail Managing Standard. \
Unlike Epeg, Epsilon has native support for PNG, and is built upon Imlib2 \
making any format supported by Imlib2 such as JPEG, PNG, XCF, TIFF and GIF. \
To provide the best possible performance Epsilon can even integrate \
with Epeg directly to harness it's speed."
SECTION = "e/libs"
LICENSE = "GPL"
DEPENDS = "epeg libpng imlib2"
PV = "${CVSDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/epsilon"
S = "${WORKDIR}/epsilon"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src/lib libepsilon ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Epsilon.h ${STAGING_INCDIR}/
}
