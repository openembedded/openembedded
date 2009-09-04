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

