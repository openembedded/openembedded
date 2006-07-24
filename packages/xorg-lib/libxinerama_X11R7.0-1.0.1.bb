DESCRIPTION = "Xinerama library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "xineramaproto xproto libx11 libxext"
PROVIDES = "xinerama"

XORG_PN = "libXinerama"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
