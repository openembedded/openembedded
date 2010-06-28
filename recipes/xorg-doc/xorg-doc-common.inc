DESCRIPTION = "X documentation"
HOMEPAGE = "http://www.x.org"
SECTION = "x11/docs"
LICENSE = "MIT-X"

SRC_URI = "${XORG_MIRROR}/individual/doc/${BPN}-${PV}.tar.bz2;name=archive"

S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
