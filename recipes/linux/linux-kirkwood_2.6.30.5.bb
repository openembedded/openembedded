DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "sheevaplug"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.30.5"

SRCREV = "6fa23e56edcb79a348c968aada8190944f4f3633"
SRC_URI = "git://git.marvell.com/orion.git;protocol=git;branch=stable-2.6.29 \
           file://defconfig \
               "

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"
