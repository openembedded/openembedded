DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PR = "r0"

DEPENDS = "libxcb"
# DEPENDS += "gperf-native"

PARALLEL_MAKE = ""

SRC_URI = "http://xcb.freedesktop.org/dist/xcb-util-0.1.tar.bz2"

PACKAGES = "libxcbatom libxcbatom-dev libxcbaux libxcbaux-dev libxcbevent libxcbevent-dev libxcbicccm libxcbicccm-dev \
            libxcbimage libxcbimage-dev libxcbkeysyms libxcbkeysyms-dev libxcbproperty libxcbproperty-dev \
            libxcbreply libxcbreply-dev libxcbwm libxcbwm-dev"

FILES_libxcbatom = "${libdir}/libXCBAtom.so.*"
FILES_libxcbatom-dev = "${libdir}/libXCBAtom.* ${libdir}/pkgconfig/xcb-atom.pc ${includedir}/X11/XCB/xcb_atom.h"
FILES_libxcbaux = "${libdir}/libXCBAux.so.*"
FILES_libxcbaux-dev = "${libdir}/libXCBAux.* ${libdir}/pkgconfig/xcb-aux.pc ${includedir}/X11/XCB/xcb_aux.h"
FILES_libxcbevent = "${libdir}/libXCBEvent.so.*"
FILES_libxcbevent-dev = "${libdir}/libXCBEvent.* ${libdir}/pkgconfig/xcb-event.pc ${includedir}/X11/XCB/xcb_event.h"
FILES_libxcbicccm = "${libdir}/libXCBICCCM.so.*"
FILES_libxcbicccm-dev = "${libdir}/libICCCM.* ${libdir}/pkgconfig/xcb-icccm.pc ${includedir}/X11/XCB/xcb_icccm.h"
FILES_libxcbimage = "${libdir}/libXCBImage.so.*"
FILES_libxcbimage-dev = "${libdir}/libXCBImage.* ${libdir}/pkgconfig/xcb-image.pc ${includedir}/X11/XCB/xcb_image.h"
FILES_libxcbkeysyms = "${libdir}/libXCBKeysyms.so.*"
FILES_libxcbkeysyms-dev = "${libdir}/libXCBKeysyms.* ${libdir}/pkgconfig/xcb-keysyms.pc ${includedir}/X11/XCB/xcb_keysyms.h"
FILES_libxcbproperty = "${libdir}/libXCBProperty.so.*"
FILES_libxcbproperty-dev = "${libdir}/libXCBProperty.* ${libdir}/pkgconfig/xcb-property.pc ${includedir}/X11/XCB/xcb_property.h"
FILES_libxcbreply = "${libdir}/libXCBReply.so.*"
FILES_libxcbreply-dev = "${libdir}/libXCBReply.* ${libdir}/pkgconfig/xcb-reply.pc ${includedir}/X11/XCB/xcb_reply.h"
FILES_libxcbwm = "${libdir}/libXCBWM.so.*"
FILES_libxcbwm-dev = "${libdir}/libXCBWM.* ${libdir}/pkgconfig/xcb-wm.pc ${includedir}/X11/XCB/xcb_wm.h"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
