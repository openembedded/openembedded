require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.37"
OLD_KERNEL_RELEASE = "2.6.36"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "35da7a307c535f9c2929cae277f3df425c9f9b1e"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
