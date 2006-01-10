DESCRIPTION = "Xinerama library"
LICENSE = "MIT"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "panoramixext xproto x11 xext"
PV = "0.0+cvs${SRCDATE}"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xinerama"
S = "${WORKDIR}/Xinerama"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
