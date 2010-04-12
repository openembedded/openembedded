DESCRIPTION = "Gstreamer RTSP server"
LICENSE = "LGPLv2"

DEPENDS = "gst-plugins-base gstreamer"

SRC_URI = "http://people.freedesktop.org/~wtay/gst-rtsp-${PV}.tar.bz2"

inherit autotools




SRC_URI[md5sum] = "8daaca1299aeb42c6aac47b30291005b"
SRC_URI[sha256sum] = "1ebf3571d16dbab401f2ebf0362e3d67457fb88711ad15a4ab51bd3730267fb7"
