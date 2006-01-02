PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT-X"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "x11 ice"
DESCRIPTION = "Session management library"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=SM"
S = "${WORKDIR}/SM"

inherit autotools pkgconfig 
