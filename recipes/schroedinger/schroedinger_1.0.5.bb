HOMEPAGE = "http://schrodinger.sourceforge.net/"
LICENSE = "MPL GPL LGPL MIT"
DEPENDS = "liboil gstreamer gst-plugins-base"

PR = "r1"

SRC_URI = "http://www.diracvideo.org/download/schroedinger/${P}.tar.gz"

inherit autotools 

PACKAGES =+ "gst-plugin-schroedinger gst-plugin-schroedinger-dev gst-plugin-schroedinger-dbg"
FILES_gst-plugin-schroedinger += "${libdir}/gstreamer-0.10/libgstschro.so"
FILES_gst-plugin-schroedinger-dev += "${libdir}/gstreamer-0.10/libgstschro.*"
FILES_gst-plugin-schroedinger-dbg += "${libdir}/gstreamer-0.10/.debug/libgstschro.so"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


