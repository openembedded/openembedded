DESCRIPTION = "Xxf86dga extension library."
SECTION = "x11/libs"
LICENSE = "XFree86"

DEPENDS = "libx11 libxext xf86dgaproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXxf86dga-${PV}.tar.bz2"
S = "${WORKDIR}/libXxf86dga-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	oe_libinstall -so -a libXxf86dga ${STAGING_LIBDIR}
}
