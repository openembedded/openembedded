DESCRIPTION = "X fontenc library (used by libxfont)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "zlib xproto"

XORG_PN = "${PN}"

include xorg-xlibs.inc
