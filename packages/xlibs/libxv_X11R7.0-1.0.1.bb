DESCRIPTION = "X Video extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxext xextproto videoproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXv-${PV}.tar.bz2"
S = "${WORKDIR}/libXv-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
