PV = "0.0cvs${CVSDATE}"
SECTION = "x11"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11 xft xtst"
DESCRIPTION = "Gesture recognition input method for X11"
LICENSE = "GPL"
SRC_URI = "cvs://anoncvs:anoncvs@xstroke.org/cvs/xstroke;module=xstroke"
S = "${WORKDIR}/xstroke"

inherit autotools pkgconfig 
