DESCRIPTION = "X Render extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "BSD"

DEPENDS = "renderproto libx11"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXrender-${PV}.tar.bz2"
S = "${WORKDIR}/libXrender-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
