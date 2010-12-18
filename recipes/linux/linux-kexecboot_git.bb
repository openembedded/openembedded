require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.37-rc7"
OLD_KERNEL_RELEASE = "2.6.36"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "90a8a73c06cc32b609a880d48449d7083327e11a"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
