require linux-kexecboot.inc

PR = "${INC_PR}.0"

KERNEL_RELEASE = "2.6.33-rc8"
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
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-${KERNEL_RELEASE}.bz2;name=rc8;patch=1 \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;patch=1;status=pending \
           file://defconfig"

SRC_URI[rc8.md5sum] = "adce988e2e7103cdb8c7024c73bcff47"
SRC_URI[rc8.sha256sum] = "10e34bd24ab7cfc43429103f39c467ac0f18584f84783b5d24d81b8e57b4544d"
SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"
