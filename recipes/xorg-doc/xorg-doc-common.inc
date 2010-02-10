DESCRIPTION = "X documentation"
HOMEPAGE = "http://www.x.org"
SECTION = "x11/docs"
LICENSE = "MIT-X"

XORG_PN = "${PN}"
SRC_URI = "${XORG_MIRROR}/individual/doc/${XORG_PN}-${PV}.tar.bz2;name=archive"

S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
