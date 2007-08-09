DESCRIPTION = "Initially a fork of the Quake2Forge project, this engine aims to provide security and performance enhancements."
LICENSE = "GPLv2"

DEPENDS = "libsdl-x11 zlib mesa"
SRC_URI = "http://tastyspleen.net/~jdolan/quetoo-${PV}-full.tar.bz2"

inherit autotools pkgconfig


EXTRA_OECONF = "\
               --with-sdl \
	       --with-zlib \
	       "

do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
	rm config.log
}

do_install_append() {
	mv ${D}${bindir}/${TARGET_PREFIX}quetoo ${D}${bindir}/quetoo
}

FILES_${PN}-dbg += "${libdir}/quetoo/baseq2/.debug"
