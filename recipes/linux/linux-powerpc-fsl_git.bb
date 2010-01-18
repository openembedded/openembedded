# This recipe builds the Linux kernel from the GIT tree for Freescale PowerPC
# This tree is not upstream and should be used for bleeding-edge testing only.

# http://git.kernel.org/?p=linux/kernel/git/galak/powerpc.git;a=summary

require linux.inc

FILESPATHPKG =. "linux-powerpc-fsl-git/${MACHINE}:"

SRCREV = "1406de8e11eb043681297adf86d6892ff8efc27a"
PV = "2.6.30"

SRCREV_calamari = "7c0a57d5c47bcfc492b3139e77400f888a935c44"

PR = "r6"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/galak/powerpc.git;protocol=git \
	   file://defconfig"

SRC_URI_append_mpc8315e-rdb = " file://mpc8315erdb-add-msi-to-dts.patch;patch=1"
SRC_URI_append_calamari = " file://mpc8536ds.dts.patch;patch=1"

COMPATIBLE_MACHINE = "(mpc8315e-rdb|calamari)"

S = "${WORKDIR}/git"
