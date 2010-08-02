DESCRIPTION = "Swfdec plugin for browsers using NPAPI. Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"
PR = "r3"
DEPENDS = "swfdec glib-2.0"
RDEPENDS_${PN} = "gst-ffmpeg"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec-mozilla/0.9/${P}.tar.gz \
"

inherit autotools pkgconfig gtk-icon-cache

EXTRA_OECONF = "--disable-static"

do_install_append() {
	rm ${D}${libdir}/mozilla/plugins/*.la
}

FILES_${PN} += "${libdir}/mozilla/plugins/*.so"
FILES_${PN}-dbg += "${libdir}/mozilla/plugins/.debug"

SRC_URI[md5sum] = "5e19c365d02f1ece2e7caec13c2b23d4"
SRC_URI[sha256sum] = "8c8cfb52b47efabefab90577fb118ab2699c803cebbc82891700f8e2d712343b"
