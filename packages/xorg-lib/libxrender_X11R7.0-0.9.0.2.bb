DESCRIPTION = "X Render extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "BSD"

DEPENDS = "renderproto libx11"

XORG_PN = "libXrender"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
