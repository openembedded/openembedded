DESCRIPTION = "Xxf86dga extension library."
SECTION = "x11/libs"
LICENSE = "XFree86"

DEPENDS = "libx11 libxext xf86dgaproto"

XORG_PN = "libXxf86dga"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	oe_libinstall -so -a libXxf86dga ${STAGING_LIBDIR}
}
