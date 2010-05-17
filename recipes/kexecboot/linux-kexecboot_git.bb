require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.34"
SRCREV = "e40152ee1e1c7a63f4777791863215e3faa37a86"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;patch=1;status=pending \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
