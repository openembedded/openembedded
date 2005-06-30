DESCRIPTION = "DirectFB is a thin library that provides developers \
with hardware graphics acceleration, input device handling and \
abstraction, an integrated windowing system with support for \
translucent windows and multiple display layers on top of the \
Linux framebuffer device."
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "jpeg libpng zlib"
PR = "r0"

SRC_URI = "http://www.directfb.org/download/DirectFB/DirectFB-${PV}.tar.gz"
S = "${WORKDIR}/DirectFB-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-gfxdrivers=none --enable-libmpeg3=no --enable-freetype=no --enable-sdl=no"
PARALLEL_MAKE = ""

do_stage() {
	oe_runmake 'DESTDIR=${STAGING_LIBDIR}/' install
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}

FILES_directfb_append = " ${libdir}/directfb-${PV}/systems/*.so \
                          ${libdir}/directfb-${PV}/inputdrivers/*.so \
                          ${libdir}/directfb-${PV}/interfaces/*/*.so \
                          ${datadir}/directfb-${PV}"
