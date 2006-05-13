DESCRIPTION = "X Resize and Rotate extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "randrproto libx11 libxrender libxext"

XORG_PN = "libXrandr"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
