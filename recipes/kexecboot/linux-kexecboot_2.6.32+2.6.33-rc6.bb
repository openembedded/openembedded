require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.33-rc6"
OLD_KERNEL_RELEASE = "2.6.32"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}"

S = "${WORKDIR}/linux-${OLD_KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_akita = "-1"
DEFAULT_PREFERENCE_c7x0 = "-1"
DEFAULT_PREFERENCE_collie = "-1"
DEFAULT_PREFERENCE_poodle = "-1"
DEFAULT_PREFERENCE_spitz = "-1"
DEFAULT_PREFERENCE_tosa = "-1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${OLD_KERNEL_RELEASE}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-${KERNEL_RELEASE}.bz2;name=rc6;patch=1 \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;patch=1;status=pending \
           file://defconfig"

SRC_URI[rc6.md5sum] = "1d20a0359a18b8822a742d62a4bae2f5"
SRC_URI[rc6.sha256sum] = "8b8ac844b7154d952469587bcb9d2cff089cc71ccd7522e38eedcdc1f2c007a5"
SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"
