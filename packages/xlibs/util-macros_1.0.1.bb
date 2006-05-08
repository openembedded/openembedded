DESCRIPTION = "X autotools macros"
SECTION = "x11/libs"
LICENSE= "Xorg"
#MAINTAINER = ""

XORG_PN = "${PN}"

include xorg-xlibs.inc

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/util/${PN}-X11R7.0-${PV}.tar.bz2"
