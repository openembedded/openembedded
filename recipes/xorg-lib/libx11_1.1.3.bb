require xorg-lib-common.inc

DESCRIPTION = "Base X libs."
DEPENDS += "bigreqsproto xproto xextproto xtrans libxau xcmiscproto \
            libxdmcp xf86bigfontproto kbproto inputproto"
PROVIDES = "virtual/libx11"
PE = "1"
PR = "r3"

XORG_PN = "libX11"

SRC_URI += "file://include_fix.patch;patch=1" 

EXTRA_OECONF += "--without-xcb --with-keysymdef=${STAGING_INCDIR}/X11/keysymdef.h"

do_compile() {
	(
		unset CC LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS
		cd src/util; touch makekeys-makekeys.o ; ${BUILD_CC} ${BUILD_CFLAGS} makekeys.c -o makekeys
		cd ../../
	) || exit 1
	oe_runmake
}

FILES_${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB ${libdir}/X11/Xcms.txt"
FILES_${PN}-locale += "${datadir}/X11/locale ${libdir}/X11/locale"

SRC_URI[archive.md5sum] = "4d43d3e472c552d2f191ecdd4e75112c"
SRC_URI[archive.sha256sum] = "4a2f566e2ea5dd955c875cb8fa9c18dd725324fc5cf4e23c803442e31ab8917a"
