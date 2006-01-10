PV = "0.0+cvs${SRCDATE}"
LICENSE= "BSD-X"
SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DESCRIPTION = "various extension headers."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XExtensions"
S = "${WORKDIR}/XExtensions"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
