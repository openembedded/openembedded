DESCRIPTION = "X Resource usage library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "X-MIT"

DEPENDS = "libx11 libxext"
PROVIDES = "xres"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXres"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
