DESCRIPTION = "X Toolkit Intrinsics"
SECTION = "x11/libs"
PRIORITY = "optional"
#MAINTAINER = ""
LICENSE =  "X-MIT"

DEPENDS = "libx11 libsm util-macros"
PROVIDES = "xt"

XORG_RELEASE = "X11R7.1"
XORG_PN = "libXt"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull --disable-install-makestrs --disable-xkb"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C util 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makestrs
	)
	oe_runmake
}
