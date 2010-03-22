DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPLv2"
COMPATIBLE_MACHINE = "(openrd-base|sheevaplug)"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.30.5"

SRCREV = "6fa23e56edcb79a348c968aada8190944f4f3633"

SRC_URI = "git://git.marvell.com/orion.git;protocol=git;branch=stable-2.6.30 \
           file://defconfig"

SRCREV_openrd-base = "8cb424312d88810bb62edbeef42a510725ceb482"
SRC_URI_append_openrd-base = " file://newer-arm-mach-types.patch;patch=1 "

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"
