require linux.inc

KERNEL_RELEASE = "2.6.30-rc5"
OLD_KERNEL_RELEASE = "2.6.29"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}"
PR = "r1"

S = "${WORKDIR}/linux-${OLD_KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

# Zaurus
DEFAULT_PREFERENCE_akita = "-1"
DEFAULT_PREFERENCE_c7x0 = "-1"
DEFAULT_PREFERENCE_collie = "-1"
DEFAULT_PREFERENCE_poodle = "-1"
DEFAULT_PREFERENCE_spitz = "-1"
DEFAULT_PREFERENCE_tosa = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${OLD_KERNEL_RELEASE}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.30/patch-${KERNEL_RELEASE}.bz2;patch=1 \
           file://defconfig"

