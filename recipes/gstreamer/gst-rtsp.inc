require gst-common.inc

DESCRIPTION = "Gstreamer RTSP server"
LICENSE = "LGPLv2"

DEPENDS += "check gst-plugins-base gstreamer"

SRC_URI = "http://people.freedesktop.org/~wtay/gst-rtsp-${PV}.tar.bz2"

