PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT"
DEPENDS = "x11 xau xmu xext"
DESCRIPTION = "X authority file utility"
MAINTAINER = "Rene Wagner <reenoo@gmx.de>"
SECTION = "x11/base"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xorg;module=xc/programs/xauth \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/xauth"

inherit autotools pkgconfig 
