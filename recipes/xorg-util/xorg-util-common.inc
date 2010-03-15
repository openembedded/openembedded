HOMEPAGE = "http://www.x.org"
SECTION = "x11/utils"
LICENSE = "MIT-X"

SRC_URI = "${XORG_MIRROR}/individual/util/${BPN}-${PV}.tar.gz;name=archive"

S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig
