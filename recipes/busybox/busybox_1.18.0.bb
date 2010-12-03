require busybox_1.1x.inc
PR = "${INC_PR}.2"

DEFAULT_PREFERENCE = "-1"

SRC_URI += " \
	file://busybox-1.18.0-buildsys.patch \
	file://busybox-1.18.0-sha.patch \
	"

SRC_URI[md5sum] = "7a8150a10558a5292fa1f52f1c65b0f5"
SRC_URI[sha256sum] = "3a9d5e6929045440ec3d0c9987376cbbb78e98886d6c5fa58fc2306d2662eb00"

