require u-boot.inc

PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-1.1.6.tar.bz2 \
           file://devkit-idp.patch;patch=1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
