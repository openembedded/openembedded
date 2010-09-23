require linux.inc

KERNEL_RELEASE = "2.6.36-rc6"
OLD_KERNEL_RELEASE = "2.6.35"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "899611ee7d373e5eeda08e9a8632684e1ebbbf00"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
