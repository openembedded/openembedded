require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.38-rc3"
OLD_KERNEL_RELEASE = "2.6.37"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "ebf53826e105f488f4f628703a108e98940d1dc5"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
