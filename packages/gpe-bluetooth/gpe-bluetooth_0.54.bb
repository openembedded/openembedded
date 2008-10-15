require gpe-bluetooth.inc

FILE_PR = "r1"

SRC_URI += "file://hciattach-bts.patch;patch=1 \
	file://include-sdp_lib.patch;patch=1"
