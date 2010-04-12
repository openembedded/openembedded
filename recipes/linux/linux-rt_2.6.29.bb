require linux.inc

# Linux kernel using the PREEMPT RT patch

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.1.bz2;patch=1;name=stablepatch \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/older/patch-${PV}.1-rt8.bz2;patch=1;name=rtpatch \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"



SRC_URI[kernel.md5sum] = "64921b5ff5cdadbccfcd3820f03be7d8"
SRC_URI[kernel.sha256sum] = "58a5ea16d499fe06f90fcbf1d687d1235d2cb9bc28bf979867bd3faadf38fc3f"
SRC_URI[stablepatch.md5sum] = "87c6fbf4096b644d66d4da8bb00641a5"
SRC_URI[stablepatch.sha256sum] = "0c44a41816082602f9d2bd45524d85f6e5fa8e4a6a9a15861048ca2aaf068d8f"
SRC_URI[rtpatch.md5sum] = "7081f2af05a873dad61fba5db69882d6"
SRC_URI[rtpatch.sha256sum] = "f13583f3143e15f6c9e0655abd8e0ca4e84c041ca16f8a47c6a104933d2545eb"
