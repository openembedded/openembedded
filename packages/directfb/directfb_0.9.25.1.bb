DESCRIPTION = "DirectFB is a thin library that provides developers \
with hardware graphics acceleration, input device handling and \
abstraction, an integrated windowing system with support for \
translucent windows and multiple display layers on top of the \
Linux framebuffer device."
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
HOMEPAGE = "http://directfb.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "jpeg libpng freetype zlib"
PR = "r0"
RV = "0.9.25"

SRC_URI = "http://directfb.org/downloads/Core/DirectFB-${PV}.tar.gz"
S = "${WORKDIR}/DirectFB-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-gfxdrivers=none --enable-libmpeg3=no --enable-freetype=yes --enable-sdl=no"
PARALLEL_MAKE = ""

do_stage() {
	oe_runmake 'DESTDIR=${STAGING_LIBDIR}/' install
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}

FILES_directfb_append = " ${libdir}/directfb-${RV}/systems/*.so \
                          ${libdir}/directfb-${RV}/inputdrivers/*.so \
                          ${libdir}/directfb-${RV}/interfaces/*/*.so \
			  ${libdir}/directfb-${RV}/wm/*.so \
                          ${datadir}/directfb-${RV}"
