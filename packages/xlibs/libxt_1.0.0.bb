DESCRIPTION = "X Toolkit Intrinsics"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE =  "X-MIT"

DEPENDS = "libx11 libsm util-macros kbproto"
PROVIDES = "xt"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/lib/libXt-X11R7.0-${PV}.tar.bz2"
S = "${WORKDIR}/libXt-X11R7.0-${PV}"

inherit autotools pkgconfig 

EXTRA_OECONF="--enable-malloc0returnsnull --disable-install-makestrs --disable-xkb"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C util 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makestrs
	)
	oe_runmake
}

do_stage () {
	autotools_stage_all
}
