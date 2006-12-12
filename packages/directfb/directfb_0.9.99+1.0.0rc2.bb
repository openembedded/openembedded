DESCRIPTION = "DirectFB is a thin library that provides developers \
with hardware graphics acceleration, input device handling and \
abstraction, an integrated windowing system with support for \
translucent windows and multiple display layers on top of the \
Linux framebuffer device."
SECTION = "libs"
LICENSE = "LGPL"
HOMEPAGE = "http://directfb.org"
DEPENDS = "jpeg libpng freetype zlib tslib"
PR = "r1"
RV = "1.0-0"

SRC_URI = "http://directfb.org/downloads/Core/DirectFB-1.0.0-rc2.tar.gz \
           file://fix-pkgconfig-specs.patch;patch=1 \
	   file://mkdfiff.patch;patch=1 \
	   file://tslib_support.patch;patch=1"

S = "${WORKDIR}/DirectFB-1.0.0-rc2"

LDFLAGS_append =" -lts -lm"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-gfxdrivers=none --enable-libmpeg3=no --enable-freetype=yes --enable-sdl=no"
PARALLEL_MAKE = ""

do_stage() {
	autotools_stage_all
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}

FILES_directfb_append = " ${libdir}/directfb-${RV}/systems/*.so \
                          ${libdir}/directfb-${RV}/inputdrivers/*.so \
                          ${libdir}/directfb-${RV}/interfaces/*/*.so \
                          ${libdir}/directfb-${RV}/wm/*.so \
                          ${datadir}/directfb-${RV}"
