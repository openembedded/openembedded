DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r0"
COMPATIBLE_MACHINE = "sheevaplug"

require linux.inc

PV = "2.6.28+2.6.29rc7-${PR}+gitr${SRCREV}"

SRCREV = "569106c70e49ad67c69fa7d43a2a5218e63a4619"
SRC_URI = "git://git.marvell.com/orion.git;protocol=git \
           file://fw.patch;patch=1 \
           file://defconfig \
               "

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"
