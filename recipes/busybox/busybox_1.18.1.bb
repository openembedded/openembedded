require busybox_1.1x.inc
PR = "${INC_PR}.5"

SRC_URI += " \
	file://busybox-1.18.1-hush.patch \
	file://busybox-1.18.1-cpio.patch \
	file://busybox-1.18.1-bzip2.patch \
	file://busybox-1.18.1-mkswap.patch \
	file://busybox-1.18.1-warning.patch \
	file://busybox-1.18.1-modprobe-small.patch \
	http://git.busybox.net/busybox/patch/id=8030a1484917d5b71d5ccd1a1d28a29da7a3d7f0;apply=yes;name=bb181-01 \
	"

SRC_URI[md5sum] = "f15fe752d8b7012aa5e59f83b88ccb1c"
SRC_URI[sha256sum] = "33eb25ea7b20c727c3af769256b21408a1ac1f927ff9f89a1f1e3767c18c9967"
SRC_URI[bb181-01.md5sum] = "fe58a0e758c2581fdd2554186089b03b"
SRC_URI[bb181-01.sha256sum] = "f776d0b4ba525c62abe5e91f1432773eca92904cdecbdf48546a9271166cd896"
