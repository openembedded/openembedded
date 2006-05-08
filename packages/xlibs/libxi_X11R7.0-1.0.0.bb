DESCRIPTION = "X Input extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "MIT-X"

DEPENDS = "xproto libx11 xextproto"

XORG_PN = "libXi"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
