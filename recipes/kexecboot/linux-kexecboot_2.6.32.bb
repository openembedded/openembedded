require linux-kexecboot.inc

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_akita = "-1"
DEFAULT_PREFERENCE_c7x0 = "-1"
DEFAULT_PREFERENCE_collie = "-1"
DEFAULT_PREFERENCE_poodle = "-1"
DEFAULT_PREFERENCE_spitz = "-1"
DEFAULT_PREFERENCE_tosa = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
#           file://v3-1-4-Add-support-for-LZO-compressed-kernels.patch;patch=1;status=pending \
#           file://v3-2-4-Add-support-for-LZO-compressed-kernels-for-ARM.patch;patch=1;status=pending \
#           file://v3-3-4-Add-support-for-LZO-compressed-kernels-on-x86.patch;patch=1;status=pending \
#           file://v3-4-4-Add-LZO-compression-support-for-initramfs-and-old-style-initrd.patch;patch=1;status=pending \
#           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;patch=1;status=pending \
           file://defconfig"

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
