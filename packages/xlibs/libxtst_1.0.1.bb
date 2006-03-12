DESCRIPTION = "X Test Extension: client side library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxext recordproto xextproto inputproto"
PROVIDES = "xtst"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXtst-${PV}.tar.bz2"
S = "${WORKDIR}/libXtst-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
