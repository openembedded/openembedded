PV = "0.0cvs${CVSDATE}"
LICENSE= "BSD-X"
SECTION = "x11/libs"
PRIORITY = "optional"
DESCRIPTION = "X Cursor library"
DEPENDS = "libxfixes"
PR = "r2"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xcursor"
S = "${WORKDIR}/Xcursor"
FILES_${PN} += "${libdir}/libXcursor.so"

inherit autotools pkgconfig 
