DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PV = "0.9+git"
PR = "r0"

PARALLEL_MAKE = ""


DEPENDS = "xcb-proto xproto libxau"
# DEPENDS += "xsltproc-native gperf-native"

SRC_URI = "git://anongit.freedesktop.org/git/xcb;protocol=git"
S = "${WORKDIR}/git/xcb"

PACKAGES = "libxcb libxcb-dev libxcbcomposite libxcbcomposite-dev \
            libxcbdamage libxcbdamage-dev libxcbdpms libxcbdpms-dev \
            libxcbglx libxcbglx-dev libxcbrandr libxcbrandr-dev \
            libxcbrecord libxcbrecord-dev libxcbrender libxcbrender-dev \
            libxcbres libxcbres-dev libxcbscreensaver libxcbscreensaver-dev \
            libxcbshape libxcbshape-dev libxcbshm libxcbshm-dev \
            libxcbsync libxcbsync-dev libxcbxevie libxcbxevie-dev \
            libxcbxf86dri libxcbxf86dri-dev libxcbxfixes libxcbxfixes-dev \
            libxcbxprint libxcbxprint-dev libxcbxtest libxcbxtest-dev \
            libxcbxv libxcbxv-dev libxcbxvmc libxcbxvmc-dev"

FILES_${PN} = "${libdir}/libXCB.so.*"
FILES_${PN}-dev = "${libdir}/libXCB.* ${libdir}/pkgconfig/xcb.pc ${includedir}/X11/XCB/xcb.h ${includedir}/X11/XCB/xcb_types.h \
                   ${includedir}/X11/XCB/xc_misc.h ${includedir}/X11/XCB/bigreq.h ${includedir}/X11/XCB/xproto.h \
                   ${includedir}/X11/XCB/xcbxlib.h ${includedir}/X11/XCB/xcbext.h"
FILES_libxcbcomposite = "${libdir}/libXCBcomposite.so*"
FILES_libxcbcomposite-dev = "${libdir}/libXCBcomposite.* ${libdir}/pkgconfig/xcb-composite.pc ${includedir}/X11/XCB/composite.h"
FILES_libxcbdamage = "${libdir}/libXCBdamage.so.*"
FILES_libxcbdamage-dev = "${libdir}/libXCBdamage.* ${libdir}/pkgconfig/xcb-damage.pc ${includedir}/X11/XCB/damage.h"
FILES_libxcbdpms = "${libdir}/libXCBdpms.so.*"
FILES_libxcbdpms-dev = "${libdir}/libXCBdpms.* ${libdir}/pkgconfig/xcb-dpms.pc ${includedir}/X11/XCB/dpms.h"
FILES_libxcbglx = "${libdir}/libXCBglx.so.*"
FILES_libxcbglx-dev = "${libdir}/libXCBglx.* ${libdir}/pkgconfig/xcb-glx.pc ${includedir}/X11/XCB/glx.h"
FILES_libxcbrandr = "${libdir}/libXCBrandr.so.*"
FILES_libxcbrandr-dev = "${libdir}/libXCBrandr.* ${libdir}/pkgconfig/xcb-randr.pc ${includedir}/X11/XCB/randr.h"
FILES_libxcbrecord = "${libdir}/libXCBrecord.so.*"
FILES_libxcbrecord-dev = "${libdir}/libXCBrecord.* ${libdir}/pkgconfig/xcb-record.pc ${includedir}/X11/XCB/record.h"
FILES_libxcbrender = "${libdir}/libXCBrender.so.*"
FILES_libxcbrender-dev = "${libdir}/libXCBrender.* ${libdir}/pkgconfig/xcb-render.pc ${includedir}/X11/XCB/render.h"
FILES_libxcbres = "${libdir}/libXCBres.so.*"
FILES_libxcbres-dev = "${libdir}/libXCBres.* ${libdir}/pkgconfig/xcb-res.pc ${includedir}/X11/XCB/res.h"
FILES_libxcbscreensaver = "${libdir}/libXCBscreensaver.so.*"
FILES_libxcbscreensaver-dev = "${libdir}/libXCBscreensaver.* ${libdir}/pkgconfig/xcb-screensaver.pc ${includedir}/X11/XCB/screensaver.h"
FILES_libxcbshape = "${libdir}/libXCBshape.so.*"
FILES_libxcbshape-dev = "${libdir}/libXCBshape.* ${libdir}/pkgconfig/xcb-shape.pc ${includedir}/X11/XCB/shape.h"
FILES_libxcbshm = "${libdir}/libXCBshm.so.*"
FILES_libxcbshm-dev = "${libdir}/libXCBshm.* ${libdir}/pkgconfig/xcb-shm.pc ${includedir}/X11/XCB/shm.h"
FILES_libxcbsync = "${libdir}/libXCBsync.so.*"
FILES_libxcbsync-dev = "${libdir}/libXCBsync.* ${libdir}/pkgconfig/xcb-sync.pc ${includedir}/X11/XCB/sync.h"
FILES_libxcbxevie = "${libdir}/libXCBxevie.so.*"
FILES_libxcbxevie-dev = "${libdir}/libXCBxevie.* ${libdir}/pkgconfig/xcb-xevie.pc ${includedir}/X11/XCB/xevie.h"
FILES_libxcbxf86dri = "${libdir}/libXCBxf86dri.so.*"
FILES_libxcbxf86dri-dev = "${libdir}/libXCBxf86dri.* ${libdir}/pkgconfig/xcb-xf86dri.pc ${includedir}/X11/XCB/xf86dri.h"
FILES_libxcbxfixes = "${libdir}/libXCBxfixes.so.*"
FILES_libxcbxfixes-dev = "${libdir}/libXCBxfixes.* ${libdir}/pkgconfig/xcb-xfixes.pc ${includedir}/X11/XCB/xfixes.h"
FILES_libxcbxprint = "${libdir}/libXCBxprint.so.*"
FILES_libxcbxprint-dev = "${libdir}/libXCBxprint.* ${libdir}/pkgconfig/xcb-xprint.pc ${includedir}/X11/XCB/xprint.h"
FILES_libxcbxtest = "${libdir}/libXCBxtest.so.*"
FILES_libxcbxtest-dev = "${libdir}/libXCBxtest.* ${libdir}/pkgconfig/xcb-xtest.pc ${includedir}/X11/XCB/xtest.h"
FILES_libxcbxv = "${libdir}/libXCBxv.so.*"
FILES_libxcbxv-dev = "${libdir}/libXCBxv.* ${libdir}/pkgconfig/xcb-xv.pc ${includedir}/X11/XCB/xv.h"
FILES_libxcbxvmc = "${libdir}/libXCBxvmc.so.*"
FILES_libxcbxvmc-dev = "${libdir}/libXCBxvmc.* ${libdir}/pkgconfig/xcb-xvmc.pc ${includedir}/X11/XCB/xvmc.h"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
