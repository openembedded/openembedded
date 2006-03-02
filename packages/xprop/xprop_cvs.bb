PV = "0.0+cvs${SRCDATE}"
LICENSE = "MIT"
DEPENDS = "libx11 libxmu libxext"
DESCRIPTION = "property displayer for X"
MAINTER = "Rene Wagner <rw@handhelds.org>"
SECTION = "x11/base"
PR = "r2"

SRC_URI = "${FREEDESKTOP_CVS}/xorg;module=xc/programs/xprop;tag=XORG-MAIN \
           file://autofoo.patch;patch=1"
S = "${WORKDIR}/xprop"

inherit autotools pkgconfig 
