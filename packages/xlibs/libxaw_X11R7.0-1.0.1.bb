DESCRIPTION = "X Athena Widgets library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "xproto libx11 libxt libxmu libxpm"
PROVIDES = "xaw"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXaw-${PV}.tar.bz2"
S = "${WORKDIR}/libXaw-${PV}"

inherit autotools pkgconfig 

# FIXME: libXaw needs a full x11, not diet
BROKEN = "1"

do_stage () {
	autotools_stage_all
}
