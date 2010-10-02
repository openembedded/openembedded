require linux-kexecboot.inc

PR = "${INC_PR}.2"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
            ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.7.bz2;apply=yes;name=stablepatch \
            file://fix.module.loading.16310.patch \
            file://defconfig"

SRC_URI[kernel.md5sum] = "091abeb4684ce03d1d936851618687b6"
SRC_URI[kernel.sha256sum] = "18b2e2c336032e366c942622b77302cb05fc034fb19018f086a4ebc9ed41bfcf"
SRC_URI[stablepatch.md5sum] = "6a00ec267b0100f20a3fa900b97a5b7f"
SRC_URI[stablepatch.sha256sum] = "e917d593b975853be4118934c35919936dec6069b35c277d26e7e85e88af062e"
