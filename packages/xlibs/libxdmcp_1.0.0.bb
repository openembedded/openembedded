DESCRIPTION = "X Display Manager Control Protocol library."
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE= "MIT"

DEPENDS = "xproto util-macros"
PROVIDES = "xdmcp"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXdmcp-${PV}.tar.bz2"
S = "${WORKDIR}/libXdmcp-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
