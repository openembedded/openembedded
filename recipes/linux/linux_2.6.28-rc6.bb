require linux.inc

KERNEL_RELEASE = "2.6.28-rc6"
PV = "2.6.27+${KERNEL_RELEASE}"
PR = "r3"

S = "${WORKDIR}/linux-${KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-${KERNEL_RELEASE}.tar.bz2 \
           file://defconfig"

SRC_URI_append_afeb9260 = " \
        file://0002-SRAM-TX-buffers-implementation-from-atmel-to-fix-TX.patch;patch=1 \
"
