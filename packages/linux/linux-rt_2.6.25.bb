require linux.inc

# Linux kernel using the PREEMPT RT patch

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"
DEFAULT_PREFERENCE_efika = "1"

PR = "r4"

#KERNEL_IMAGETYPE_efika = "Image"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.25.4.bz2;patch=1 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/older/patch-2.6.25.4-rt6.bz2;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.25"


