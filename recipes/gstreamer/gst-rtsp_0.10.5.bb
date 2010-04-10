DESCRIPTION = "Gstreamer RTSP server"
LICENSE = "LGPLv2"

DEPENDS = "gst-plugins-base gstreamer"

SRC_URI = "http://people.freedesktop.org/~wtay/gst-rtsp-${PV}.tar.bz2"

inherit autotools



SRC_URI[md5sum] = "caca55e2ff497c0a327df3bc65a4a662"
SRC_URI[sha256sum] = "a6f0a0c6c466683ee688aa8475623850fdacb549b2339a502831fdd3d74f984e"
