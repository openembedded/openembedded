DESCRIPTION = "X autotools macros"
SECTION = "x11/libs"
LICENSE= "Xorg"
#MAINTAINER = ""

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/util/${PN}-X11R7.0-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}-X11R7.0-${PV}"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
