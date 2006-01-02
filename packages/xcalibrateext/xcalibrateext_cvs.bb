PV = "0.0cvs${CVSDATE}"
SECTION = "x11/libs"
LICENSE = "BSD-X"
DESCRIPTION = "XCalibrate extension headers"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XCalibrateExt"
S = "${WORKDIR}/XCalibrateExt"

inherit autotools pkgconfig
