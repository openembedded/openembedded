PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT"
DEPENDS = "x11 xmu xext"
DESCRIPTION = "property displayer for X"
MAINTER = "Rene Wagner <reenoo@gmx.de>"
SECTION = "x11/base"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xorg;module=xc/programs/xprop;tag=XORG-MAIN \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/xprop"

inherit autotools pkgconfig 
