require busybox_1.1x.inc
PR = "${INC_PR}.6"

SRC_URI += " \
	file://busybox-1.18.1-hush.patch \
	file://busybox-1.18.1-cpio.patch \
	file://busybox-1.18.1-bzip2.patch \
	file://busybox-1.18.1-mkswap.patch \
	file://busybox-1.18.1-warning.patch \
	file://busybox-1.18.1-modprobe-small.patch \
	file://busybox-1.18.1-tftp.patch \
	file://busybox-1.18.1-httpd.patch \
	"

SRC_URI[md5sum] = "f15fe752d8b7012aa5e59f83b88ccb1c"
SRC_URI[sha256sum] = "33eb25ea7b20c727c3af769256b21408a1ac1f927ff9f89a1f1e3767c18c9967"
