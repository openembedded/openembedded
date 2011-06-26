require linux-kexecboot.inc

KERNEL_RELEASE = "3.0-rc4"
OLD_KERNEL_RELEASE = "2.6.39"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "56299378726d5f2ba8d3c8cbbd13cb280ba45e4f"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
