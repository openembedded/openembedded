require linux.inc

KERNEL_RELEASE = "2.6.36-rc8"
OLD_KERNEL_RELEASE = "2.6.35"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "2d019713b7acbc01d769a1e512ca1f9a04c30bd0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
