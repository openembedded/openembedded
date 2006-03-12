DESCRIPTION = "Authorization Protocol for X."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "xproto util-macros"
PROVIDES = "xau"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXau-${PV}.tar.bz2"
S = "${WORKDIR}/libXau-${PV}"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
