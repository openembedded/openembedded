PV = "0.0cvs${CVSDATE}"
LICENSE = "BSD-X"
SECTION = "x11/libs"
DEPENDS = "randrext x11 libxrender xext"
DESCRIPTION = "X Resize and Rotate extension library."
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xrandr"
S = "${WORKDIR}/Xrandr"

inherit autotools pkgconfig 
