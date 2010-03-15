DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPLv2"
COMPATIBLE_MACHINE = "sheevaplug"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.29.5"
PR_append = "+gitr${SRCREV}"
#PV = "2.6.28+2.6.29rc7-${PR}+gitr${SRCREV}"

SRCREV = "70deca35020a5dc3bd3c228bd46852cab77a7f6b"
SRC_URI = "git://git.marvell.com/orion.git;protocol=git;branch=stable-2.6.29 \
           file://fw.patch;patch=1 \
           file://0001--ARM-Kirkwood-CPU-idle-driver.patch;patch=1 \
           file://0002--ARM-Kirkwood-peripherals-clock-gating-for-power-m.patch;patch=1 \
           file://defconfig \
               "

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"
