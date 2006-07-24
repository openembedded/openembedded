DESCRIPTION = "X11 keyboard library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxt libxkbfile kbproto"

XORG_PN = "${PN}"

include xorg-xlibs.inc

