require xorg-lib-common.inc

DESCRIPTION = "Base X libs."
DEPENDS += "bigreqsproto xproto xextproto xtrans libxau xcmiscproto \
            libxdmcp xf86bigfontproto kbproto inputproto xproto-native"
PROVIDES = "virtual/libx11"
PE = "1"

XORG_PN = "libX11"

SRC_URI += "file://x11_disable_makekeys.patch;patch=1 \
            file://keysymdef_include.patch;patch=1"

EXTRA_OECONF += "--without-xcb --with-keysymdef=${STAGING_INCDIR}/X11/keysymdef.h"

# Dolt gets used on x86 and ppc and hardcodes 'libtool'
do_configure_append() {
        cp ${TARGET_PREFIX}libtool libtool || true
}

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

SRC_URI[archive.md5sum] = "c6265b59ea2b594fd68e33f9125b4d20"
SRC_URI[archive.sha256sum] = "e4863cdf5d471763806e9bcae25ea47606a56cd91a5546a34c093aa3de181051"
