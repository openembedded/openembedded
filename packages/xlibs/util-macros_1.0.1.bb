DESCRIPTION = "X autotools macros"
SECTION = "x11/libs"
LICENSE= "Xorg"
#MAINTAINER = ""

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/util/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
