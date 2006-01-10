DESCRIPTION = "Xinerama library"
LICENSE = "MIT"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "panoramixext xproto x11 xext"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xinerama;date=20050505"
S = "${WORKDIR}/Xinerama"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
