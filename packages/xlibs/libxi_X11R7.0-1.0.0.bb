DESCRIPTION = "X Input extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "MIT-X"

DEPENDS = "xproto libx11 xextproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXi-${PV}.tar.bz2"
S = "${WORKDIR}/libXi-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
