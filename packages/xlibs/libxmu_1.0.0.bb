DESCRIPTION = "X Window System miscellaneous utility library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "libxt libxext util-macros"
PROVIDES = "xmu"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXmu-${PV}.tar.bz2"
S = "${WORKDIR}/libXmu-${PV}"

PACKAGES =+ "libxmuu libxmuu-dev"

FILES_libxmuu = "${libdir}/libXmuu.so.*"
FILES_libxmuu-dev = "${libdir}/libXmuu.so"

LEAD_SONAME = "libXmu"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
