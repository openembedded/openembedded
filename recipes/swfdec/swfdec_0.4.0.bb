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


SRC_URI[md5sum] = "157d31c9dc02aa22b5f27323e5a203fc"
SRC_URI[sha256sum] = "c31d3bbee984c7971d2b24cddc279d8ad65edff8216778d617484c147ba3ae3d"
