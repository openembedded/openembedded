PV = "0.0+cvs${SRCDATE}"
LICENSE = "BSD-X"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libxfont xtrans"

SRC_URI = "${FREEDESKTOP_CVS}/xlibs;module=FS"
S = "${WORKDIR}/FS"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
