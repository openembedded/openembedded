DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "sheevaplug"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.29.1"
PR_append = "+gitr${SRCREV}"
#PV = "2.6.28+2.6.29rc7-${PR}+gitr${SRCREV}"

SRCREV = "f66f1d49e6d8617a07b07681c684083e48547eef"
SRC_URI = "git://git.marvell.com/orion.git;protocol=git;branch=stable-2.6.29 \
           file://fw.patch;patch=1 \
           file://defconfig \
               "

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"
