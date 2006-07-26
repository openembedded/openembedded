SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "${FREEDESKTOP_CVS}/dri;module=drm;method=pserver"

PV = "0.0+cvs${SRCDATE}"
PR = "r2"

S = "${WORKDIR}/drm"

inherit autotools

do_compile() {
	oe_runmake -C libdrm
}

do_stage() {
	autotools_stage_all
}


