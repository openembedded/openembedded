# "+" is missing due to bug in Familiar
PV = "0.0cvs${SRCDATE}"
PR = "r1"
LICENSE= "MIT"
DESCRIPTION = "X Server Extension library"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "xproto virtual/libx11 xextensions"
PROVIDES = "xext"

SRC_URI = "${FREEDESKTOP_CVS}/xlibs;module=Xext"
S = "${WORKDIR}/Xext"

inherit autotools pkgconfig
do_stage() {
	autotools_stage_all
}

