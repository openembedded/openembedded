DESCRIPTION = "DirectFB is a thin library that provides developers \
with hardware graphics acceleration, input device handling and \
abstraction, an integrated windowing system with support for \
translucent windows and multiple display layers on top of the \
Linux framebuffer device."
SECTION = "libs"
LICENSE = "LGPL"
HOMEPAGE = "http://directfb.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "jpeg libpng freetype zlib"
PR = "r1"
RV = "0.9.25"

SRC_URI = "http://directfb.org/downloads/Core/DirectFB-${PV}.tar.gz \
           file://fix-pkgconfig-specs.patch;patch=1"
S = "${WORKDIR}/DirectFB-${PV}"

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
