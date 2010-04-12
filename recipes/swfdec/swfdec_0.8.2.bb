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

SRC_URI[md5sum] = "2fb20b04c0e426a1e894a4c4bf22cf87"
SRC_URI[sha256sum] = "10fd6f07264d3fbd92c03858a99637cd4b9d98ab00fb4d31720adce0c1ed7af4"
