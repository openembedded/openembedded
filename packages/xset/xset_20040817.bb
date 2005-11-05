DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
FIXEDCVSDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.0cvs${FIXEDCVSDATE}"
PR = "r1"

DEPENDS = "x11 xext xextensions xmu"

CFLAGS += "-D_GNU_SOURCE"

SECTION = "x11/base"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xorg;module=xc/programs/xset;date=${FIXEDCVSDATE} \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/xset"

inherit autotools pkgconfig 
