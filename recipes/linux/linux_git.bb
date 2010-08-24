require linux.inc

KERNEL_RELEASE = "2.6.36-rc2"
OLD_KERNEL_RELEASE = "2.6.35"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "d1b113bb028999e82a8528e1484be8c23fb5a7d9"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
