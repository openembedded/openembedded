require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.38-rc8"
OLD_KERNEL_RELEASE = "2.6.37"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "a5abba989deceb731047425812d268daf7536575"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://0001-arm-include-asm-tlb.h-fix-CONFIG_SWAP-n-build-for-AR.patch \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
