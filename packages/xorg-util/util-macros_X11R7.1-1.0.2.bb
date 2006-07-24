DESCRIPTION = "X autotools macros"
SECTION = "x11/libs"
LICENSE= "Xorg"
#MAINTAINER = ""

XORG_PN = "${PN}"
XORG_RELEASE = "X11R7.1"

include xorg-xlibs.inc

SRC_URI = "${XORG_MIRROR}/X11R7.1/src/util/${PN}-X11R7.1-${PV}.tar.bz2"
