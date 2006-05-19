DESCRIPTION = "X Composite extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libx11 compositeproto xextproto libxfixes"
PROVIDES = "xcomposite"

XORG_PN = "libXcomposite"

include xorg-xlibs.inc

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXcomposite-${PV}.tar.bz2 \
	   file://change-include-order.patch;patch=1"
