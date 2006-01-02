PV = "0.0cvs${CVSDATE}"
PR = "r1"
LICENSE= "MIT"
DESCRIPTION = "X Server Extension library"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "xproto x11 xextensions"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xext"
S = "${WORKDIR}/Xext"

inherit autotools pkgconfig 
