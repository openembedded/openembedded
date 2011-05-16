require busybox_1.1x.inc

SRC_URI += "file://fix-iptunnel-location.patch \
	http://busybox.net/downloads/fixes-1.18.4/busybox-1.18.4-hush.patch;name=patch01"

PR = "${INC_PR}.2"

SRC_URI[md5sum] = "b03c5b46ced732679e525a920a1a62f5"
SRC_URI[sha256sum] = "4d24d37bd6f1bd153e8cf9a984ec2f32f18464f73ca535e2cc2e8be9694097fa"
SRC_URI[patch01.md5sum] = "a81f2d7d3bdf1a35ab77c4414a530d38"
SRC_URI[patch01.sha256sum] = "c87e73ad942d53c8a2a5ffe6037c1cdf52d4b20d3f29caae5fffc7a99009b7cb"
