PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "xproto x11 xt xmu xpm"
DESCRIPTION = "X Athena Widgets library"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xaw"
S = "${WORKDIR}/Xaw"

inherit autotools pkgconfig 

# FIXME: libXaw needs a full x11, not diet
BROKEN = "1"
