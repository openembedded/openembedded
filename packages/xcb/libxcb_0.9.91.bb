DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PR = "r0"

PARALLEL_MAKE = ""
DEPENDS = "xcb-proto libxau"
# DEPENDS += "xsltproc-native gperf-native"

SRC_URI = "http://xcb.freedesktop.org/dist/libxcb-${PV}.tar.bz2"

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

FILES_${PN} = "${libdir}/libxcb.so.*"
FILES_${PN}-dev = "${libdir}/libxcb.* ${libdir}/pkgconfig/xcb.pc ${includedir}/xcb/xcb.h ${includedir}/xcb/xcb_types.h \
                   ${includedir}/xcb/xc_misc.h ${includedir}/xcb/bigreq.h ${includedir}/xcb/xproto.h \
                   ${includedir}/xcb/xcbxlib.h ${includedir}/xcb/xcbext.h"
FILES_libxcbcomposite = "${libdir}/libxcbcomposite.so*"FILES_libxcbcomposite-dev = "${libdir}/libxcbcomposite.* ${libdir}/pkgconfig/xcb-composite.pc ${includedir}/xcb/composite.h"
FILES_libxcbdamage = "${libdir}/libxcbdamage.so.*"FILES_libxcbdamage-dev = "${libdir}/libxcbdamage.* ${libdir}/pkgconfig/xcb-damage.pc ${includedir}/xcb/damage.h"
FILES_libxcbdpms = "${libdir}/libxcbdpms.so.*"
FILES_libxcbdpms-dev = "${libdir}/libxcbdpms.* ${libdir}/pkgconfig/xcb-dpms.pc ${includedir}/xcb/dpms.h"
FILES_libxcbglx = "${libdir}/libxcbglx.so.*"
FILES_libxcbglx-dev = "${libdir}/libxcbglx.* ${libdir}/pkgconfig/xcb-glx.pc ${includedir}/xcb/glx.h"
FILES_libxcbrandr = "${libdir}/libxcbrandr.so.*"
FILES_libxcbrandr-dev = "${libdir}/libxcbrandr.* ${libdir}/pkgconfig/xcb-randr.pc ${includedir}/xcb/randr.h"
FILES_libxcbrecord = "${libdir}/libxcbrecord.so.*"
FILES_libxcbrecord-dev = "${libdir}/libxcbrecord.* ${libdir}/pkgconfig/xcb-record.pc ${includedir}/xcb/record.h"
FILES_libxcbrender = "${libdir}/libxcbrender.so.*"
FILES_libxcbrender-dev = "${libdir}/libxcbrender.* ${libdir}/pkgconfig/xcb-render.pc ${includedir}/xcb/render.h"
FILES_libxcbres = "${libdir}/libxcbres.so.*"
FILES_libxcbres-dev = "${libdir}/libxcbres.* ${libdir}/pkgconfig/xcb-res.pc ${includedir}/xcb/res.h"
FILES_libxcbscreensaver = "${libdir}/libxcbscreensaver.so.*"
FILES_libxcbscreensaver-dev = "${libdir}/libxcbscreensaver.* ${libdir}/pkgconfig/xcb-screensaver.pc ${includedir}/xcb/screensaver.h"
FILES_libxcbshape = "${libdir}/libxcbshape.so.*"
FILES_libxcbshape-dev = "${libdir}/libxcbshape.* ${libdir}/pkgconfig/xcb-shape.pc ${includedir}/xcb/shape.h"
FILES_libxcbshm = "${libdir}/libxcbshm.so.*"
FILES_libxcbshm-dev = "${libdir}/libxcbshm.* ${libdir}/pkgconfig/xcb-shm.pc ${includedir}/xcb/shm.h"
FILES_libxcbsync = "${libdir}/libxcbsync.so.*"
FILES_libxcbsync-dev = "${libdir}/libxcbsync.* ${libdir}/pkgconfig/xcb-sync.pc ${includedir}/xcb/sync.h"
FILES_libxcbxevie = "${libdir}/libxcbxevie.so.*"
FILES_libxcbxevie-dev = "${libdir}/libxcbxevie.* ${libdir}/pkgconfig/xcb-xevie.pc ${includedir}/xcb/xevie.h"
FILES_libxcbxf86dri = "${libdir}/libxcbxf86dri.so.*"
FILES_libxcbxf86dri-dev = "${libdir}/libxcbxf86dri.* ${libdir}/pkgconfig/xcb-xf86dri.pc ${includedir}/xcb/xf86dri.h"
FILES_libxcbxfixes = "${libdir}/libxcbxfixes.so.*"
FILES_libxcbxfixes-dev = "${libdir}/libxcbxfixes.* ${libdir}/pkgconfig/xcb-xfixes.pc ${includedir}/xcb/xfixes.h"
FILES_libxcbxprint = "${libdir}/libxcbxprint.so.*"
FILES_libxcbxprint-dev = "${libdir}/libxcbxprint.* ${libdir}/pkgconfig/xcb-xprint.pc ${includedir}/xcb/xprint.h"
FILES_libxcbxtest = "${libdir}/libxcbxtest.so.*"
FILES_libxcbxtest-dev = "${libdir}/libxcbxtest.* ${libdir}/pkgconfig/xcb-xtest.pc ${includedir}/xcb/xtest.h"
FILES_libxcbxv = "${libdir}/libxcbxv.so.*"
FILES_libxcbxv-dev = "${libdir}/libxcbxv.* ${libdir}/pkgconfig/xcb-xv.pc ${includedir}/xcb/xv.h"
FILES_libxcbxvmc = "${libdir}/libxcbxvmc.so.*"
FILES_libxcbxvmc-dev = "${libdir}/libxcbxvmc.* ${libdir}/pkgconfig/xcb-xvmc.pc ${includedir}/xcb/xvmc.h"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
