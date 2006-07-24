DESCRIPTION = "X Test Extension: client side library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxext recordproto xextproto inputproto"
PROVIDES = "xtst"

XORG_PN = "libXtst"

include xorg-xlibs.inc
