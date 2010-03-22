require gst-common.inc

DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."

DEPENDS = "libxml2 glib-2.0 gettext-native popt"

SRC_URI = "http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-${PV}.tar.bz2;name=archive"
EXTRA_OECONF = "--disable-docs-build --disable-dependency-tracking --with-check=no"

FILES_${PN} += " ${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dev += " ${libdir}/gstreamer-0.10/*.la ${libdir}/gstreamer-0.10/*.a"
FILES_${PN}-dbg += "${libexecdir}/gstreamer-0.10/.debug ${libdir}/gstreamer-0.10/.debug"

