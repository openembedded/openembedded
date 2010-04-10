DESCRIPTION = "Swfdec plugin for browsers using NPAPI. Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

DEPENDS = "swfdec glib-2.0"
RDEPENDS = "gst-ffmpeg"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec-mozilla/0.8/${P}.tar.gz \
"

inherit autotools pkgconfig gtk-icon-cache

EXTRA_OECONF = "--disable-static"

do_install_append() {
	rm ${D}${libdir}/mozilla/plugins/*.la
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/mozilla/plugins/*.so"
FILES_${PN}-dbg += "${libdir}/mozilla/plugins/.debug"


SRC_URI[md5sum] = "716632e0d35b3c1582c180569ba30346"
SRC_URI[sha256sum] = "49fd905f41b67832e7b2cfa2cf664657ab08f8fef4a2324e74202fc951396cd5"
