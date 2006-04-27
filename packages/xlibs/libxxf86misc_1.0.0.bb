DESCRIPTION = "Xxf86vm extension library."
SECTION = "x11/libs"
LICENSE = "MIT"

DEPENDS = "libx11 libxext xf86miscproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXxf86misc-${PV}.tar.bz2"
S = "${WORKDIR}/libXxf86misc-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
