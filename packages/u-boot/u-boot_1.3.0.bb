require u-boot.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2"

PACKAGE_ARCH = "${MACHINE_ARCH}"
