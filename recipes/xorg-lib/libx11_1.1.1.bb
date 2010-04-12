require xorg-lib-common.inc
PE = "1"
PR = "r5"

DESCRIPTION = "Base X libs."
DEPENDS += " bigreqsproto xproto xextproto xtrans libxau xcmiscproto \
	libxdmcp xf86bigfontproto kbproto inputproto"
PROVIDES = "virtual/libx11"

XORG_PN = "libX11"

EXTRA_OECONF += "--without-xcb"

SRC_URI += " file://ruutf8.patch;patch=1"

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

SRC_URI[archive.md5sum] = "848b80f77b20ae1fa5c882bbfa531ebc"
SRC_URI[archive.sha256sum] = "5359db57793430429786b648ac570d4ab205797306e049bf1e8675250af21541"
