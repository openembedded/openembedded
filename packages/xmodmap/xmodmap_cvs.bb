PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT"
DESCRIPTION = "utility for modifying keymaps and pointer button mappings in X"
MAINTAINER = "Rene Wagner <reenoo@gmx.de>"
SECTION = "x11/base"

DEPENDS = "x11"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xorg;module=xc/programs/xmodmap \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/xmodmap"

inherit autotools pkgconfig 
