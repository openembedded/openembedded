DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_MACHINE = "openrd-base|openrd-client|sheevaplug"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.32-rc4"

SRCREV = "1f76e2412659d2619ccd933d0ffd15e6253b1c4e"

SRC_URI = "git://repo.or.cz/linux-2.6/linux-2.6-openrd.git;protocol=git \
           file://defconfig"

SRC_URI_append_openrd-client += "file://0003-ARM-Kirkwood-Sound-Sound-driver-added.patch;patch=1"

# update machine types list for ARM architecture, only for machines that need it
do_arm_mach_types() {
#  if test ${MACHINE} == openrd-base || test ${MACHINE} == openrd-client; then
    curl -o mach-types "http://www.arm.linux.org.uk/developer/machines/download.php" && \
    cp mach-types arch/arm/tools/mach-types
#  fi
}

addtask arm_mach_types after do_patch before do_configure

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"

