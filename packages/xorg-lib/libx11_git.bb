DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "Xlib/XCB: Xlib with XCB transport"
SECTION = "x11/libs"
LICENSE = "XFree86"
DEPENDS = "libxcb xproto xextproto libxau xtrans libxdmcp xcmiscproto xf86bigfontproto kbproto inputproto bigreqsproto util-macros"
PROVIDES = "virtual/libx11"
PR = "r3"

FILES_${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB"
FILES_${PN}-locale += "${datadir}/X11/locale"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libX11;protocol=git"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-malloc0returnsnull"


do_compile() {
        (
         unset CC LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS
         cd src/util; touch makekeys-makekeys.o ; ${BUILD_CC} ${BUILD_CFLAGS} makekeys.c -o makekeys
         cd ../../
        ) || exit 1
        oe_runmake
}


do_stage() {
	autotools_stage_all
}
