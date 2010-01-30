require linux.inc

KERNEL_RELEASE = "2.6.33-rc6"
OLD_KERNEL_RELEASE = "2.6.32"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}"
PR = "r1"

S = "${WORKDIR}/linux-${OLD_KERNEL_RELEASE}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_simone = "-1"
DEFAULT_PREFERENCE_akita = "-1"
DEFAULT_PREFERENCE_c7x0 = "-1"
DEFAULT_PREFERENCE_collie = "-1"
DEFAULT_PREFERENCE_poodle = "-1"
DEFAULT_PREFERENCE_spitz = "-1"
DEFAULT_PREFERENCE_tosa = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${OLD_KERNEL_RELEASE}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-${KERNEL_RELEASE}.bz2;name=rc6;patch=1 \
           file://defconfig"

SRC_URI[rc6.md5sum] = "1d20a0359a18b8822a742d62a4bae2f5"
SRC_URI[rc6.sha256sum] = "8b8ac844b7154d952469587bcb9d2cff089cc71ccd7522e38eedcdc1f2c007a5"
SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"

# Zaurus family bootloader patches
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"
ZAURUSPATCHES = " ${RPSRC}/pxa-linking-bug-r1.patch;patch=1;status=unmergable;name=pxa-linking-bug-r1 "
SRC_URI[pxa-linking-bug-r1.md5sum] = "1e2a99787260c3566033e7f41180e2c8"
SRC_URI[pxa-linking-bug-r1.sha256sum] = "785d2680022325ad54c1593082dce902f5fee31dae4c1922ba43956b1dcfcd8b"

# Machine specific patches
SRC_URI_append_akita = "${ZAURUSPATCHES}"
SRC_URI_append_c7x0 = "${ZAURUSPATCHES}"
SRC_URI_append_collie = "${ZAURUSPATCHES}"
SRC_URI_append_poodle = "${ZAURUSPATCHES}"
SRC_URI_append_spitz = "${ZAURUSPATCHES}"
SRC_URI_append_tosa = "${ZAURUSPATCHES}"
