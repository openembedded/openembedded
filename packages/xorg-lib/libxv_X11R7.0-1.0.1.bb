DESCRIPTION = "X Video extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxext xextproto videoproto"

XORG_PN = "libXv"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"
