require u-boot.inc

PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-1.2.0.tar.bz2 \
	"
SRC_URI_append_turbostation = "file://uboot-qnap.diff;patch=1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
