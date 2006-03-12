DESCRIPTION = "X Cursor library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libxfixes"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXcursor-${PV}.tar.bz2"
S = "${WORKDIR}/libXcursor-${PV}"

FILES_${PN} += "${libdir}/libXcursor.so"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
