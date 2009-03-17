require gpe-bluetooth.inc

PR = "r1"

SRC_URI += "file://hciattach-bts.patch;patch=1 \
	file://include-sdp_lib.patch;patch=1"
