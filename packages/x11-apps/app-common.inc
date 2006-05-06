DESCRIPTION = "X application"
SECTION = "x11/apps"
LICENSE= "MIT-X"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-X11R7.0-${PV}.tar.bz2"

S = ${WORKDIR}/${PN}-X11R7.0-${PV}

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
