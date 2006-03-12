DESCRIPTION = "X font library (used by the X server)."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "BSD-X"

DEPENDS = "xproto xtrans zlib fontcacheproto fontsproto libfontenc"
PROVIDES = "xfont"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXfont-${PV}.tar.bz2"
S = "${WORKDIR}/libXfont-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
