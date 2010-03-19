SECTION = "kernel"
DESCRIPTION = "Linux kernel for SH4 based TITAN (NP51R/LinkGear Series 100) router appliance"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	   file://titan-flash.patch;patch=1 \
	   file://titan-pcibios-scan-update.patch;patch=1 \
           file://no-mm-mutex.patch;patch=1 \
	   file://linux-2.6-limits.patch;patch=1 \
	   file://linux-sh-__sdivsi3_i4i.patch;patch=1 \
	   file://titan-config"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'sh4.*-linux'
COMPATIBLE_MACHINE = "titan"

inherit kernel

ARCH = "sh"
KERNEL_OUTPUT = "arch/${ARCH}/boot/${KERNEL_IMAGETYPE}"

#
# Use an updated defconfig which includes the flash driver
# The flash driver quality doesn't allow it to be a part of the main kernel
#
do_configure_prepend() {
	install -m 0644 ${WORKDIR}/titan-config ${S}/arch/sh/configs/titan_defconfig
	yes '' | oe_runmake titan_defconfig
}
