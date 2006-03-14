DESCRIPTION = "X Damage extension library."
SECTION = "x11/libs"
#MAINTAINER = ""
LICENSE= "BSD-X"

DEPENDS = "libx11 damageproto libxfixes xproto"
PROVIDES = "xdamage"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXdamage-${PV}.tar.bz2"
S = "${WORKDIR}/libXdamage-${PV}"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}
