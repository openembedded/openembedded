PV = "0.0cvs${CVSDATE}"
DEPENDS = "x11 xmu xext"
DESCRIPTION = "X server resource database utility"
MAINTAINER = "Rene Wagner <reenoo@gmx.de>"
SECTION = "x11/base"
LICENSE = "xrdb"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xorg;module=xc/programs/xrdb \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/xrdb"

inherit autotools pkgconfig 
