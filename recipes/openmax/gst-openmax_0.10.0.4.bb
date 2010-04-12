DESCRIPTION = "GstOpenMAX is a GStreamer plug-in that allows communication with OpenMAX IL components"
LICENSE = "LGPLv2"
DEPENDS = "gstreamer libomxil-bellagio"

SRC_URI = "http://gstreamer.freedesktop.org/src/gst-openmax/pre/gst-openmax-${PV}.tar.bz2 \
           file://check.diff;patch=1 \
          "

inherit autotools

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.*a"


SRC_URI[md5sum] = "5c250ac8027ba855bc46b1bf8aefa658"
SRC_URI[sha256sum] = "79e3618edd959e29c877b9f8b0c9156d8249d725096582dffdd5308ba6a0e645"
