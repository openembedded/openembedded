DESCRIPTION = "Base X libs."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "XFree86"

DEPENDS = "xproto xextproto libxau xtrans libxdmcp xcmiscproto xf86bigfontproto kbproto inputproto bigreqsproto util-macros"
PROVIDES = "x11"

FILES_${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB"
FILES_${PN}-locale += "${datadir}/X11/locale"

XORG_PN = "libX11"

include xorg-xlibs.inc

EXTRA_OECONF="--enable-malloc0returnsnull"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C src/util 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makekeys
	)
	rm -f ${STAGING_INCDIR}/X11/Xlib.h
	oe_runmake
}
