DESCRIPTION = "X Fixes extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libx11 fixesproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXfixes-${PV}.tar.bz2"
S = "${WORKDIR}/libXfixes-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
