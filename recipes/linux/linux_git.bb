require linux.inc

KERNEL_RELEASE = "2.6.35-rc6"
SRCREV = "b37fa16e78d6f9790462b3181602a26b5af36260"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://fix.module.loading.16310.patch \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
