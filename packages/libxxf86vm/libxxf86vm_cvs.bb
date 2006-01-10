PV = "0.0+cvs${SRCDATE}"
LICENSE = "MIT"

SECTION = "x11/libs"
DEPENDS = "x11 xext xxf86vmext"
DESCRIPTION = "Xxf86vm extension library."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xxf86vm"
S = "${WORKDIR}/Xxf86vm"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
