DESCRIPTION = "Swfdec plugin for browsers using NPAPI. Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

PR = "r2"

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


SRC_URI[md5sum] = "3bc6a49357b4b8b478ce3dfb4f007f18"
SRC_URI[sha256sum] = "84962251e647fdcdcf111bef0c478f7d3679ae104267ba72e59ad749c6955cc2"
