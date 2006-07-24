DESCRIPTION = "X Resource usage library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "X-MIT"

DEPENDS = "libx11 xextproto libxext resourceproto"
PROVIDES = "xres"

XORG_PN = "libXres"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
