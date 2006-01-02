PV = "0.0cvs${CVSDATE}"
PR = "r1"
SECTION = "libs"
DEPENDS = "renderext x11"
DESCRIPTION = "X Render extension library."
LICENSE = "BSD"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xrender"
S = "${WORKDIR}/Xrender"

inherit autotools pkgconfig 
