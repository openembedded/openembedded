DESCRIPTION = "X11 keyboard library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11"

XORG_RELEASE = "X11R7.1"
XORG_PN = "${PN}"

include xorg-xlibs.inc
