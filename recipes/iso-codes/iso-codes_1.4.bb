LICENSE = "LGPL"
PACKAGE_ARCH = "all"
SRC_URI = "ftp://pkg-isocodes.alioth.debian.org/pub/pkg-isocodes/iso-codes-${PV}.tar.bz2"
PR = "r2"

inherit autotools_stage

FILES_${PN} += "${datadir}/xml/"
