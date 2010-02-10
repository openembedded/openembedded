DESCRIPTION = "X protocol headers: ${XORG_PN}"
HOMEPAGE = "http://www.x.org"
SECTION = "x11/libs"
LICENSE = "MIT-X"

DEPENDS = "util-macros"

XORG_PN = "${PN}"

ALLOW_EMPTY = "1"

SRC_URI = "${XORG_MIRROR}/individual/proto/${XORG_PN}-${PV}.tar.bz2;name=archive"

S = "${WORKDIR}/${XORG_PN}-${PV}"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}
