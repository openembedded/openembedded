require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.35"
SRCREV = "9fe6206f400646a2322096b56c59891d530e8d51"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
            file://fix.module.loading.16310.patch \
            file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
