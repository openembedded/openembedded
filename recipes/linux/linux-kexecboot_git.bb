require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.39-rc7"
OLD_KERNEL_RELEASE = "2.6.38"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "3568bd9720b4a775f28a718fcbb462ce2f386988"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
