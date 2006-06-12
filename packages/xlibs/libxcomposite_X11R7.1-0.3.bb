DESCRIPTION = "X Composite extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libx11 compositeproto libxfixes"
PROVIDES = "xcomposite"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXcomposite"

include xorg-xlibs.inc

SRC_URI = "${XORG_MIRROR}/${XORG_RELEASE}/src/lib/libXcomposite-${PV}.tar.bz2 \
	   file://change-include-order.patch;patch=1"
