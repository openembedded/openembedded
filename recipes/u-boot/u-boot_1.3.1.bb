require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
           file://mpc8313e-rdb-autoboot.patch;patch=1 \
           file://mpc8313e-rdb-mtdparts.patch;patch=1 \
           file://mpc8313e-rdb-nand.patch;patch=1"


SRC_URI[md5sum] = "8fbd29c7e70c524a42d18b9c3f3a4aa1"
SRC_URI[sha256sum] = "64811b4ab4ca362b01a3d08f53a2dbbf059e18484b90cb5e21c0365d53b87f77"
