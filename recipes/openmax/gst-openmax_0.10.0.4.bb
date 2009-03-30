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

