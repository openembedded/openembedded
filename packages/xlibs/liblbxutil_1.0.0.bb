DESCRIPTION = "X11 keyboard library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "xextproto"

XORG_PN = "${PN}"

include xorg-xlibs.inc

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/${PN}-X11R7.0-${PV}.tar.bz2 \
		   file://mkg3states.patch;patch=1"

export CC_FOR_BUILD = "${BUILD_CC}"
export CFLAGS_FOR_BUILD = "${BUILD_CFLAGS}"
