DESCRIPTION = "Base X libs."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "XFree86"
PE = "1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

DEPENDS = "xproto-native xextproto-native libxau-native xtrans-native libxdmcp-native xcmiscproto-native xf86bigfontproto-native kbproto-native inputproto-native bigreqsproto-native util-macros-native"
PROVIDES = "x11-native"

XORG_PN = "libX11"

SRC_URI = "${XORG_MIRROR}/individual/lib/${XORG_PN}-1.0.1.tar.bz2"
S = "${WORKDIR}/libX11-${PV}"

inherit native autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C src/util 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makekeys
	)
	rm -f ${STAGING_INCDIR}/X11/Xlib.h
	oe_runmake
}

SRC_URI[md5sum] = "58f0537f21183e27149cf906a1b6bef9"
SRC_URI[sha256sum] = "f99e4ce6d8e3b8833957978fe22223897b0e636c83580f2b07eff0388eb75294"
