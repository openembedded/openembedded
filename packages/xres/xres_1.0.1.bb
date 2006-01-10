SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "x11 xextensions xext resourceext"
DESCRIPTION = "X Resource usage library."
LICENSE = "X-MIT"
SRC_URI = "${XLIBS_MIRROR}/libXres-${PV}.tar.bz2"
S = "${WORKDIR}/libXres-${PV}"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
