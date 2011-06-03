require busybox_1.1x.inc

SRC_URI += "file://fix-iptunnel-location.patch \
	http://busybox.net/downloads/fixes-1.18.4/busybox-1.18.4-hush.patch;name=patch01"

PR = "${INC_PR}.2"

SRC_URI[md5sum] = "b03c5b46ced732679e525a920a1a62f5"
SRC_URI[sha256sum] = "4d24d37bd6f1bd153e8cf9a984ec2f32f18464f73ca535e2cc2e8be9694097fa"
SRC_URI[patch01.md5sum] = "91005640b4b434ab5029fa5a0349a33c"
SRC_URI[patch01.sha256sum] = "e76da947c40784c9a0527c38b1e9edb615c80cfe911d28b9d8a5d67a492bf67c"
