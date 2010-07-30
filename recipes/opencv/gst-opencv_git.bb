DESCRIPTION = "A collection of elements for the GStreamer multimedia framework which provide access to a number of computer vision techniques from the OpenCV project "
LICENSE = "LGPLv2"

DEPENDS = "opencv gstreamer ffmpeg"

inherit autotools

CFLAGS += " -I${STAGING_INCDIR}/opencv"

PE = "1"
PV = "0.10.0.1"
PR = "r1"
PR_append = "+gitr${SRCPV}"
SRCREV = "c767c38c847b0ee32b0a"
SRC_URI = "git://github.com/Elleo/gst-opencv.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN}-dbg += "${libdir}/gstreamer-*/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-*/*.la"
FILES_${PN}-static += "${libdir}/gstreamer-*/*.a"
FILES_${PN} += "${libdir}/gstreamer-*/*.so"

