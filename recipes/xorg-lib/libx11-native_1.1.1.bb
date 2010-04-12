DESCRIPTION = "Base X libs."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "XFree86"
PE = "1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

DEPENDS = "xproto-native xextproto-native libxau-native xtrans-native libxdmcp-native xcmiscproto-native xf86bigfontproto-native kbproto-native inputproto-native bigreqsproto-native util-macros-native"
PROVIDES = "x11-native"

XORG_PN = "libX11"

SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-1.1.1.tar.bz2"
S = "${WORKDIR}/libX11-${PV}"

inherit native autotools pkgconfig

EXTRA_OECONF += "--without-xcb"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C src/util 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makekeys
	)
	rm -f ${STAGING_INCDIR}/X11/Xlib.h
	oe_runmake
}

SRC_URI[md5sum] = "848b80f77b20ae1fa5c882bbfa531ebc"
SRC_URI[sha256sum] = "5359db57793430429786b648ac570d4ab205797306e049bf1e8675250af21541"
