DESCRIPTION = "X Input extension library."
SECTION = "x11/libs"
LICENSE = "MIT-X"

DEPENDS = "xproto libx11 xext"

XORG_PN = "libXi"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
