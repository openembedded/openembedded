DESCRIPTION = "X Server Extension library"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "xproto libx11 xextproto util-macros"
PROVIDES = "xext"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXext-${PV}.tar.bz2"
S = "${WORKDIR}/libXext-${PV}"

inherit autotools pkgconfig 

EXTRA_OECONF="--enable-malloc0returnsnull"

do_stage() {
	autotools_stage_all
}
