require linux.inc

PR = "r1"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_afeb9260 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_afeb9260 = " \
        file://0002-SRAM-TX-buffers-implementation-from-atmel-to-fix-TX.patch;patch=1 \
"
