DESCRIPTION = "X11 keyboard library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
