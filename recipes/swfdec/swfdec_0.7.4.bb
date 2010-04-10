DESCRIPTION = "Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

DEPENDS = "gstreamer libsoup-2.4 pango cairo liboil zlib libmad gtk+ alsa-lib"

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



SRC_URI[md5sum] = "08fcda4a46454bfc66b97fba2d385f8c"
SRC_URI[sha256sum] = "4345da2a4790125bd7205bd10a3326bf94e36f97229850b99ec9e8f050a9ab4a"
