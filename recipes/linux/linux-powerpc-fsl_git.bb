# This recipe builds the Linux kernel from the GIT tree for Freescale PowerPC
# This tree is not upstream and should be used for bleeding-edge testing only.

require linux.inc

FILESPATHPKG =. "linux-powerpc-fsl-git/${MACHINE}:"

SRCREV = "1406de8e11eb043681297adf86d6892ff8efc27a"

PV = "2.6.30"
PR = "r4"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/galak/powerpc.git;protocol=git \
	   file://defconfig"

SRC_URI_append_mpc8315e-rdb = " file://mpc8315erdb-add-msi-to-dts.patch;patch=1"

COMPATIBLE_MACHINE = "mpc8315e-rdb"

S = "${WORKDIR}/git"
