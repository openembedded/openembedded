require schroedinger.inc
PR = "r2"

DEPENDS += "gstreamer gst-plugins-base"

SRC_URI = "http://www.diracvideo.org/download/schroedinger/schroedinger-${PV}.tar.gz"

S = "${WORKDIR}/schroedinger-${PV}"

PACKAGES = "gst-plugin-schroedinger gst-plugin-schroedinger-dev gst-plugin-schroedinger-dbg"
FILES_gst-plugin-schroedinger += "${libdir}/gstreamer-0.10/libgstschro.so"
FILES_gst-plugin-schroedinger-dev += "${libdir}/gstreamer-0.10/libgstschro.*"
FILES_gst-plugin-schroedinger-dbg += "${libdir}/gstreamer-0.10/.debug/libgstschro.so"

