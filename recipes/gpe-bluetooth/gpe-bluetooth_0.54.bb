require gpe-bluetooth.inc

PR = "r1"

SRC_URI += "file://hciattach-bts.patch;patch=1 \
	file://include-sdp_lib.patch;patch=1"

SRC_URI[md5sum] = "197603d957dda95a92c92038fb9f8341"
SRC_URI[sha256sum] = "5ffb41e7375c55450fc55428fd7b19e158a93ee91ae6b9519953363ec05f82c7"
