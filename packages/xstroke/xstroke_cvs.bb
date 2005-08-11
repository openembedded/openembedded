DESCRIPTION = "Gesture recognition input method for X11"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11 xft xtst xpm"
PV = "0.0cvs${CVSDATE}"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@xstroke.org/cvs/xstroke;module=xstroke"
S = "${WORKDIR}/xstroke"

inherit autotools pkgconfig 
