DESCRIPTION = "X protocol headers: ${XORG_PN}"
HOMEPAGE = "http://www.x.org"
SECTION = "x11/libs"
LICENSE = "MIT-X"

DEPENDS = "util-macros"

ALLOW_EMPTY = "1"

SRC_URI = "${XORG_MIRROR}/individual/proto/${BPN}-${PV}.tar.bz2;name=archive"

S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}
