require xorg-lib-common.inc

PR = "r4"

DESCRIPTION = "Base X libs."
SRC_URI += "file://makekeys.diff;patch=1"

DEPENDS += " bigreqsproto xproto xextproto xtrans libxau xcmiscproto \
	libxdmcp xf86bigfontproto kbproto inputproto"
PROVIDES = "virtual/libx11"
RPROVIDES = "virtual/libx11"

XORG_PN = "libX11"

FILES_${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB ${libdir}/X11/Xcms.txt"
FILES_${PN}-locale += "${datadir}/X11/locale ${libdir}/X11/locale"

do_compile() {
	(
	 unset CC LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS
	 cd src/util; touch makekeys-makekeys.o ; ${BUILD_CC} ${BUILD_CFLAGS} makekeys.c -o makekeys
	) || exit 1
		rm -f ${STAGING_INCDIR}/X11/Xlib.h
	oe_runmake
}
