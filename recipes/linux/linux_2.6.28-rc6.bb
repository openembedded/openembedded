require linux.inc

KERNEL_RELEASE = "2.6.28-rc6"
PV = "2.6.27+${KERNEL_RELEASE}"
PR = "r3"

S = "${WORKDIR}/linux-${KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.28/linux-${KERNEL_RELEASE}.tar.bz2 \
           file://defconfig"

SRC_URI_append_afeb9260 = " \
        file://0002-SRAM-TX-buffers-implementation-from-atmel-to-fix-TX.patch;patch=1 \
"
SRC_URI[md5sum] = "b94ed91fcc77cce6627cebba89695c75"
SRC_URI[sha256sum] = "c5e7857c257491bbb40cf18f576f72df8480cad4980dea399d887e5c46c86279"
