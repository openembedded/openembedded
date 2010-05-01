require linux.inc

KERNEL_RELEASE = "2.6.34-rc6"
SRCREV = "be1066bbcd443a65df312fdecea7e4959adedb45"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;patch=1;status=pending \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
