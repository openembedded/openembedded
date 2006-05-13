LICENSE = "MIT"
DEPENDS = "libx11 libxext libxmu"
DESCRIPTION = "server access control program for X"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "x11/base"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-X11R7.0-${PV}.tar.bz2"
S = "${WORKDIR}/${PN}-X11R7.0-${PV}"

inherit autotools pkgconfig 
