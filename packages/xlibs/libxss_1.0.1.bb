DESCRIPTION = "X screen saver extension library."
SECTION = "libs"
#MAINTAINER = ""
LICENSE = "GPL"

DEPENDS = "libx11 libxext xextproto scrnsaverproto"
PROVIDES = "libxss"
RREPLACES = "libxss"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXScrnSaver-${PV}.tar.bz2"
S = "${WORKDIR}/libXScrnSaver-${PV}"

inherit autotools pkgconfig

#CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"
EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
