DESCRIPTION = "X Server Extension library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "xproto libx11 util-macros"
PROVIDES = "xext"

EXTRA_OECONF="--enable-malloc0returnsnull"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXext"

include xorg-xlibs.inc

