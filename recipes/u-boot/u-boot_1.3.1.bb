require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
           file://mpc8313e-rdb-autoboot.patch;patch=1 \
           file://mpc8313e-rdb-mtdparts.patch;patch=1 \
           file://mpc8313e-rdb-nand.patch;patch=1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
