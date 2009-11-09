DESCRIPTION = "Linux 2.6 kernel for the AMD Geode GX processor"
LICENSE = "GPL"

require linux.inc
COMPATIBLE_MACHINE = "geodegx"

PR = "r0"
S = "${WORKDIR}/linux-${PV}"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_geodegx = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"
