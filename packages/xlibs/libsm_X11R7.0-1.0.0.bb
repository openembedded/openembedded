DESCRIPTION = "Session management library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT-X"
#PV="1:1.0.0"

DEPENDS = "libx11 libice util-macros"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libSM-${PV}.tar.bz2"
S = "${WORKDIR}/libSM-${PV}"

inherit autotools pkgconfig 

do_stage () {
	autotools_stage_all
}
