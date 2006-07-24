DESCRIPTION = "X Render extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "BSD"

DEPENDS = "renderproto libx11"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXrender"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
