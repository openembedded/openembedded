DESCRIPTION = "X Event Viewer"
HOMEPAGE = "http://freedesktop.org/wiki/Software_2fxapps"
LICENSE = "MIT"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "x11/base"
DEPENDS = "libx11 libxau"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-${PV}.tar.bz2 \
	   file://diet-x11.patch;patch=1"

inherit autotools
