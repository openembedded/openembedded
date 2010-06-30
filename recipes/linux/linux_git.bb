require linux.inc

KERNEL_RELEASE = "2.6.35-rc3"
SRCREV = "5904b3b81d25166e5e39b9727645bb47937618e3"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
           file://use-noclone-attribute-for-naked.patch;status=pending \
           file://defconfig"

S = "${WORKDIR}/git"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
