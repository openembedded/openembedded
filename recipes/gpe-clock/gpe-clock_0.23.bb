require gpe-clock.inc

PR = "${INC_PR}.0"

SRC_URI += "file://fix-install.patch;patch=1"

SRC_URI[md5sum] = "050943c68ee61ef8f2a25410a60d725e"
SRC_URI[sha256sum] = "5a1d21538353fbb2038b3948385fa32faec1951162cd0d2c52a2687c7fc6669b"
