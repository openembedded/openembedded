require xorg-lib-common.inc

DESCRIPTION = "Base X libs."
DEPENDS += "bigreqsproto xproto xextproto xtrans libxau xcmiscproto \
            libxdmcp xf86bigfontproto kbproto inputproto xproto-native"
PROVIDES = "virtual/libx11"
PE = "1"
PR = "r3"

XORG_PN = "libX11"

SRC_URI += "file://x11_disable_makekeys.patch;patch=1 \
            file://include_fix.patch;patch=1" 

EXTRA_OECONF += "--without-xcb --with-keysymdef=${STAGING_INCDIR}/X11/keysymdef.h"

do_compile() {
	(
		unset CC LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS
		cd src/util; 
		mv makekeys.c.orig makekeys.c || true
		sed -i -e 's:MIN_REHASH 15:MIN_REHASH 16:g' makekeys.c
		touch makekeys-makekeys.o ; ${BUILD_CC} ${BUILD_CFLAGS} -I${STAGING_INCDIR_NATIVE} makekeys.c -o makekeys
		# mv to stop it getting rebuilt
		mv makekeys.c makekeys.c.orig
		cd ../../
	) || exit 1
	oe_runmake
}

FILES_${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB ${libdir}/X11/Xcms.txt"
FILES_${PN}-locale += "${datadir}/X11/locale ${libdir}/X11/locale"

SRC_URI[archive.md5sum] = "1469a5a8aa8d288dce6f4c45d2f68dc3"
SRC_URI[archive.sha256sum] = "bdbd6d239435c1736f5c532b12e8078761db8db5f37ab3195fe11c3e5b692c1c"
