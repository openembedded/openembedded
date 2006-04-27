DESCRIPTION = "X data files"
SECTION = "x11/data"
LICENSE= "MIT-X"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/data/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
