require xorg-lib-common.inc

DESCRIPTION = "Base X libs."
DEPENDS += "bigreqsproto xproto xextproto xtrans libxau xcmiscproto \
            libxdmcp xf86bigfontproto kbproto inputproto xproto-native"
PROVIDES = "virtual/libx11"
PE = "1"
PR = "r3"

XORG_PN = "libX11"

SRC_URI += "file://x11_disable_makekeys.1.6.3.patch;patch=1 \
            file://dolt-fix.patch;patch=1 \
            file://keysymdef_include.patch;patch=1"

EXTRA_OECONF += "--without-xcb --with-keysymdef=${STAGING_INCDIR}/X11/keysymdef.h"

do_compile() {
	(
		unset CC LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS
		cd src/util; 
		mv makekeys.c.orig makekeys.c || true
		touch makekeys-makekeys.o ; ${BUILD_CC} ${BUILD_CFLAGS} -I${STAGING_INCDIR_NATIVE} makekeys.c -o makekeys
		# mv to stop it getting rebuilt
		mv makekeys.c makekeys.c.orig
		cd ../../
	) || exit 1
	oe_runmake
}

FILES_${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB ${libdir}/X11/Xcms.txt"
FILES_${PN}-locale += "${datadir}/X11/locale ${libdir}/X11/locale"

SRC_URI[archive.md5sum] = "001d780829f936e34851ef7cd37b4dfd"
SRC_URI[archive.sha256sum] = "4def4d5c9fce85d690f1f29d675154594acdea3d3fe792d0cb513732c7b4bcb2"
