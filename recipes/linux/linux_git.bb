require linux.inc

KERNEL_RELEASE = "2.6.35-rc5"
SRCREV = "f469461df6ff822f71b8737bda86eea20f16ff93"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://fix.module.loading.16310.patch \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
