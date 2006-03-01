LICENSE = "MIT"
DESCRIPTION = "Xinerama library"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "panoramixext xproto libx11 libxext"
PROVIDES = "xinerama"
PR = "r1"

SRC_URI = "${XLIBS_MIRROR}/libXinerama-${PV}.tar.bz2"
S = "${WORKDIR}/libXinerama-${PV}"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
