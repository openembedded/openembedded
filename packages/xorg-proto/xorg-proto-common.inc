DESCRIPTION = "X protocol headers"
SECTION = "x11/libs"
LICENSE= "MIT-X"
#MAINTAINER = ""

SRC_URI = "${XORG_MIRROR}/${XORG_RELEASE}/src/proto/${PN}-${XORG_RELEASE}-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}-${XORG_RELEASE}-${PV}"

XORG_RELEASE ?= "X11R7.0"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
