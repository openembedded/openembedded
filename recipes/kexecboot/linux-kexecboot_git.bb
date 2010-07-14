require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.35-rc5"
SRCREV = "1c5474a65bf15a4cb162dfff86d6d0b5a08a740c"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
