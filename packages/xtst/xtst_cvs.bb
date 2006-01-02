LICENSE = "GPL"
PV = "0.0cvs${CVSDATE}"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "x11 recordext xext"
DESCRIPTION = "X Test Extension: client side library"
PR = "r3"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xtst"
S = "${WORKDIR}/Xtst"

inherit autotools pkgconfig 
