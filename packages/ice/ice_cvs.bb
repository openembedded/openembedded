PV = "0.0+cvs${SRCDATE}"
LICENSE= "MIT"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11"
DESCRIPTION = "X11 ICE library"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=ICE"
S = "${WORKDIR}/ICE"

inherit autotools pkgconfig 

do_stage () {
	autotools_stage_all
}
