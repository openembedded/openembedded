DESCRIPTION = "X Resource usage library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "X-MIT"

DEPENDS = "libx11 xextproto libxext resourceproto"
PROVIDES = "xres"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXres-${PV}.tar.bz2"
S = "${WORKDIR}/libXres-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
