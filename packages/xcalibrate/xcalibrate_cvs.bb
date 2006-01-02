PV = "0.0cvs${CVSDATE}"
LICENSE = "BSD-X"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "x11 xcalibrateext xext"
DESCRIPTION = "XCalibrate client-side library"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XCalibrate"
S = "${WORKDIR}/XCalibrate"

inherit autotools pkgconfig 
