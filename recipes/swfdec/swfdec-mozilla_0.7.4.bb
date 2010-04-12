DESCRIPTION = "Swfdec plugin for browsers using NPAPI. Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

PR = "r1"

DEPENDS = "gst-ffmpeg swfdec gstreamer libsoup-2.4 pango cairo liboil zlib gtk+ alsa-lib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"
RDEPENDS = "gst-ffmpeg"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec-mozilla/0.7/${P}.tar.gz \
"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/mozilla/plugins/*.so"
FILES_${PN}-dev += "${libdir}/mozilla/plugins/*a"
FILES_${PN}-dbg += "${libdir}/mozilla/plugins/.debug"


SRC_URI[md5sum] = "c5958f3b003190b21977495021ac2b28"
SRC_URI[sha256sum] = "0d7927f2e791321b2867c120eb4140d9017c59b77925eb909b2a03f3ef2a8fe4"
