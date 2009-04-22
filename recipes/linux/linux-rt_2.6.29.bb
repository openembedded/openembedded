require linux.inc

# Linux kernel using the PREEMPT RT patch

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.1.bz2;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-${PV}.1-rt8.bz2;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"


