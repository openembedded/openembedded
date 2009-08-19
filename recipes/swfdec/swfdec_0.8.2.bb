DESCRIPTION = "Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

DEPENDS = "gstreamer gst-plugins-base libsoup-2.4 pango cairo liboil zlib gtk+ alsa-lib"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec/0.8/${P}.tar.gz \
"

inherit autotools pkgconfig 

EXTRA_OECONF = "--disable-static"

do_install_append() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/player/.libs/swfplay ${D}/${bindir}
}

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libswfdecgtk libswfdec"
FILES_libswfdec = "${libdir}/libswfdec-0.8.so.*"
FILES_libswfdecgtk = "${libdir}/libswfdec-gtk-0.8.so.*"
