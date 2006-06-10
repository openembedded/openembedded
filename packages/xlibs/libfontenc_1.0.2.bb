DESCRIPTION = "X fontenc library (used by libxfont)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "zlib xproto"

XORG_RELEASE = "X11R7.1"
XORG_PN = "${PN}"

include xorg-xlibs.inc
