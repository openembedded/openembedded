PV = "0.0+cvs${SRCDATE}"
SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "x11 xextensions xext resourceext"
DESCRIPTION = "X Resource usage library."
LICENSE = "X-MIT"
SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XRes"
S = "${WORKDIR}/XRes"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
