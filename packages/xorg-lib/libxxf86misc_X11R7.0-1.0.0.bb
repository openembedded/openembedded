DESCRIPTION = "Xxf86vm extension library."
SECTION = "x11/libs"
LICENSE = "MIT"
DEPENDS = "libx11 libxext xf86miscproto"

XORG_PN = "libXxf86misc"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"

