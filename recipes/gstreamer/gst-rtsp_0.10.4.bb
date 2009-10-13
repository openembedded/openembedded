DESCRIPTION = "Gstreamer RTSP server"
LICENSE = "LGPLv2"

DEPENDS = "gst-plugins-base gstreamer"

SRC_URI = "http://people.freedesktop.org/~wtay/gst-rtsp-${PV}.tar.bz2"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"


