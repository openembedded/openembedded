LICENSE = "MIT"
SECTION = "x11/libs"
DESCRIPTION = "network API translation layer to \
insulate X applications and libraries from OS \
network vageries."

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/${PN}-${PV}.tar.bz2"

inherit autotools  pkgconfig

do_stage() {
	autotools_stage_all
}
