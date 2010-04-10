DESCRIPTION = "Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"
PR = "r1"
DEPENDS = "gstreamer gst-plugins-base libsoup-2.4 pango cairo liboil zlib gtk+ alsa-lib"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec/0.9/${P}.tar.gz \
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

FILES_libswfdec = "${libdir}/libswfdec-0.9.so.*"
FILES_libswfdecgtk = "${libdir}/libswfdec-gtk-0.9.so.*"

SRC_URI[md5sum] = "7be5e39236e2d6efa61a18e83e5ab73d"
SRC_URI[sha256sum] = "7d56a3044c19e7ca4b492f3739d9aa6f6bdb6e51ecf4daa5d29c035ae430f1ef"
