DESCRIPTION = "Session management library"
SECTION = "libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE = "MIT-X"
#PV="1:1.0.0"

DEPENDS = "libx11 libice util-macros"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libSM-1.0.0.tar.bz2"
S = "${WORKDIR}/libSM-1.0.0"

inherit autotools pkgconfig 

do_stage () {
	autotools_stage_all
}
