PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT"
SECTION = "x11/libs"
DESCRIPTION = "Xxf86vm extension headers"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XF86VMExt"
S = "${WORKDIR}/XF86VMExt"

inherit autotools pkgconfig
