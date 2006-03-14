DESCRIPTION = "X11 ICE library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "libx11 util-macros"
PROVIDES = "ice"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libICE-${PV}.tar.bz2"
S = "${WORKDIR}/libICE-${PV}"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
