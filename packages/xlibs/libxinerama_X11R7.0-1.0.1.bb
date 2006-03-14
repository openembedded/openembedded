DESCRIPTION = "Xinerama library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT"

DEPENDS = "xineramaproto xproto libx11 libxext"
PROVIDES = "xinerama"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXinerama-${PV}.tar.bz2"
S = "${WORKDIR}/libXinerama-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
