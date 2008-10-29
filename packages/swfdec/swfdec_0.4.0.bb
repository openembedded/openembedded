DESCRIPTION = "Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

DEPENDS = "pango cairo liboil zlib gtk+ alsa-lib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"
PR = "r1"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec/0.4/${P}.tar.gz \
           file://jsautocfg.h \
	   file://fix-cross-build.patch;patch=1"

inherit autotools pkgconfig lib_package

do_configure_append() {
	cp -f ${WORKDIR}/jsautocfg.h ${S}/libswfdec/js
}

