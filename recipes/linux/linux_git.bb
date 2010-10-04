require linux.inc

KERNEL_RELEASE = "2.6.36-rc7"
OLD_KERNEL_RELEASE = "2.6.35"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "cb655d0f3d57c23db51b981648e452988c0223f9"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
