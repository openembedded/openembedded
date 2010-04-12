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

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${OLD_KERNEL_RELEASE}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.30/patch-${KERNEL_RELEASE}.bz2;patch=1;name=patch \
           file://defconfig"


SRC_URI[kernel.md5sum] = "64921b5ff5cdadbccfcd3820f03be7d8"
SRC_URI[kernel.sha256sum] = "58a5ea16d499fe06f90fcbf1d687d1235d2cb9bc28bf979867bd3faadf38fc3f"
SRC_URI[patch.md5sum] = "2f399a5e286a9fe7cb40bfd3d42a7a3d"
SRC_URI[patch.sha256sum] = "79a9913a74e58af6431bb952aac2cf0a1f4422287f420844f24ca6bc5ed0fdc4"
