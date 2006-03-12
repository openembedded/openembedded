DESCRIPTION = "X Resize and Rotate extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "randrproto libx11 libxrender libxext"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXrandr-${PV}.tar.bz2"
S = "${WORKDIR}/libXrandr-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
