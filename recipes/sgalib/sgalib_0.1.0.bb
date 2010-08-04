DESCRIPTION = "Nomadik userland graphical acceleration library"
SECTION = "x11"
DEPENDS = "virtual/kernel"
LICENSE = "LGPL2+"

SRC_URI = "file://sgalib-${PV}.tar.gz"

S = "${WORKDIR}/sgalib-${PV}"

COMPATIBLE_MACHINE = "nhk15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools

EXTRA_OECONF = "--with-kernelsrcdir=${STAGING_KERNEL_DIR}"
