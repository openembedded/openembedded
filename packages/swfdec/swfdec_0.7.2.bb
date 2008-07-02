DESCRIPTION = "Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

DEPENDS = "pango cairo liboil zlib libmad gtk+ alsa-lib"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec/0.7/${P}.tar.gz \
"

inherit autotools pkgconfig 

do_install_append() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/player/.libs/swfplay ${D}/${bindir}
}

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libswfdecgtk libswfdec"

FILES_${PN} += "${datadir}/icons"
FILES_libswfdec = "${libdir}/libswfdec-0.7.so.*"
FILES_libswfdecgtk = "${libdir}/libswfdec-gtk-0.7.so*"


