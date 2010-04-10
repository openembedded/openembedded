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

SRC_URI[archive.md5sum] = "710bf38a9477a5a1b235bc94f1d0593c"
SRC_URI[archive.sha256sum] = "b77e4fd2bbd4092e7e78d0964760ad8ab160caccd4bc6d7d0c87a23febaea85e"
