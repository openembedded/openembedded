DESCRIPTION = "X print extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "libx11 libxext xextproto libxau printproto"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXp-${PV}.tar.bz2"
S = "${WORKDIR}/libXp-${PV}"

inherit autotools pkgconfig

CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"
EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
