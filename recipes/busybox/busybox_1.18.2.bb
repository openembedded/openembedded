require busybox_1.1x.inc
PR = "${INC_PR}.1"

SRC_URI += " \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-modprobe-small.patch;name=patch01 \
	"

SRC_URI[md5sum] = "69a82091e5710b72db5ce0e14e7c0cd7"
SRC_URI[sha256sum] = "aa7e1cec8cd9c7f4e56098b9e4bb2ab5d593d5a35f766ad9e6a312289bf57080"
SRC_URI[patch01.md5sum] = "dda72eaf33d19d6a0ac78e46e9411cfd"
SRC_URI[patch01.sha256sum] = "ed5d83040414d035138bf484ccd514817342b143baff43ffff6ba556952de7ed"
