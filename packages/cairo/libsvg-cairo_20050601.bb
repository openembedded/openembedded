PV = "0.0+cvs${FIXEDSRCDATE}"
FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"

SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "libsvg cairo"
DESCRIPTION = "SVG rendering library"
DEFAULT_PREFERENCE = "1"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=libsvg-cairo;date=${FIXEDSRCDATE}"
S = "${WORKDIR}/libsvg-cairo"

inherit autotools pkgconfig 

do_stage () {
	autotools_stage_all
}
