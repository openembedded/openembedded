# This recipe builds the Linux kernel from the GIT tree for Freescale PowerPC
# This tree is not the upstream kernel release so use with caution.

# http://git.kernel.org/?p=linux/kernel/git/galak/powerpc.git;a=summary

require linux.inc

FILESPATHPKG =. "linux-powerpc-fsl-git/${MACHINE}:"

SRCREV = "9fe6206f400646a2322096b56c59891d530e8d51"
PV = "2.6.35"

PR = "r0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/galak/powerpc.git;protocol=git \
	   file://defconfig"

# Use format (x|y|z) when adding y, z
COMPATIBLE_MACHINE = "(p1020rdb|p2020rdb)"

S = "${WORKDIR}/git"
