require linux.inc

KERNEL_RELEASE = "2.6.37-rc8"
OLD_KERNEL_RELEASE = "2.6.36"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "387c31c7e5c9805b0aef8833d1731a5fe7bdea14"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
