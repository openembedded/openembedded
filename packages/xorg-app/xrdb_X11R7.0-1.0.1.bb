DEPENDS = "libx11 libxmu libxext"
DESCRIPTION = "X server resource database utility"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "x11/base"
LICENSE = "xrdb"
PR = "r0"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-X11R7.0-1.0.1.tar.bz2"
S = "${WORKDIR}/${PN}-X11R7.0-${PV}"

inherit autotools pkgconfig 
