require linux.inc

KERNEL_RELEASE = "2.6.37-rc6"
OLD_KERNEL_RELEASE = "2.6.36"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "b0c3844d8af6b9f3f18f31e1b0502fbefa2166be"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
