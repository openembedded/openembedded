LICENSE = "GPL"
PV = "0.0cvs${CVSDATE}"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "x11"
DESCRIPTION = "X11 keyboard library"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=xkbfile"
S = "${WORKDIR}/xkbfile"

inherit autotools pkgconfig 
