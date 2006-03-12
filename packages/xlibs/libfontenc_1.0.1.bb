DESCRIPTION = "X fontenc library (used by libxfont)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "zlib xproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
