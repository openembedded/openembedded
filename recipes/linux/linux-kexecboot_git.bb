require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.39-rc4"
OLD_KERNEL_RELEASE = "2.6.38"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "f0e615c3cb72b42191b558c130409335812621d8"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
