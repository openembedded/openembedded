DESCRIPTION = "Twin is a text-mode windowing environment: it draws and manages text windows on a text-mode display, like X11 does for graphical windows. It has a built-in window manager and terminal emulator, and can be used as server for remote clients in the same style as X11. It can display on Linux console, on X11 and inside itself."
MAINTAINER = "Chris Lord <cwiiis@blueyonder.co.uk>"
SECTION = "console/utils"

DEPENDS = "coreutils-native"
LICENSE = "GPL LGPL"
SRC_URI = "http://linuz.sns.it/~max/twin/twin-0.4.6.tar.gz \
	   file://cross_compile.patch;patch=1"

EXTRA_OECONF = " --disable-tt-hw-x11 --disable-hw-x11 --disable-tt-hw-gtk"

inherit autotools

do_compile () {
	oe_runmake 'HOSTCC=${BUILD_CC}'
}

do_stage () {
	oe_soinstall libs/libTw/libTw.so.3.0.9 ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/Tw
	install -m 0644 include/Tw/*.h ${STAGING_INCDIR}/Tw/
}
