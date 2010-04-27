DESCRIPTION = "A collection of elements for the GStreamer multimedia framework which provide access to a number of computer vision techniques from the OpenCV project "
LICENSE = "LGPLv2"

DEPENDS = "opencv gstreamer ffmpeg"

inherit autotools

PV = "0.10.0.1+gitr${SRCPV}"
SRCREV = "4514ee1608f001e85f264001355a76b5607b2144"
SRC_URI = "git://github.com/Elleo/gst-opencv.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN}-dbg += "${libdir}/gstreamer-*/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-*/*.la"
FILES_${PN}-static += "${libdir}/gstreamer-*/*.a"
FILES_${PN} += "${libdir}/gstreamer-*/*.so"

