# This recipe builds the Linux kernel from the GIT tree for Freescale PowerPC
# This tree is not upstream and should be used for bleeding-edge testing only.

require linux.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-powerpc-git/${MACHINE}"

SRCREV = "1406de8e11eb043681297adf86d6892ff8efc27a"

PV = "2.6.30"
PR = "r0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/galak/powerpc.git;protocol=git \
	   file://defconfig"

COMPATIBLE_MACHINE = "mpc8315e-rdb"

S = "${WORKDIR}/git"
