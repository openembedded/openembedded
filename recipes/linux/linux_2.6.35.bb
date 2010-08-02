require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           file://fix.module.loading.16310.patch \
           file://defconfig"

SRC_URI[kernel.md5sum] = "091abeb4684ce03d1d936851618687b6"
SRC_URI[kernel.sha256sum] = "18b2e2c336032e366c942622b77302cb05fc034fb19018f086a4ebc9ed41bfcf"
