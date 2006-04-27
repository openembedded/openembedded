DESCRIPTION = "X application"
SECTION = "x11/apps"
LICENSE= "MIT-X"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
