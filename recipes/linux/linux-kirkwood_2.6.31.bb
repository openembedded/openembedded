DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_MACHINE = "openrd-base"

# SheevaPlug still needs testing
#COMPATIBLE_MACHINE = "(openrd-base|sheevaplug)"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.31"

# last commit at the time of release of upstream v2.6.31
SRCREV = "8cb424312d88810bb62edbeef42a510725ceb482"

SRC_URI = "git://git.marvell.com/orion.git;protocol=git \
           file://defconfig"

# update machine types list for ARM architecture, only for machines that need it
do_arm_mach_types() {
  if test ${MACHINE} == openrd-base; then
    curl -o mach-types "http://www.arm.linux.org.uk/developer/machines/download.php" && \
    cp mach-types arch/arm/tools/mach-types
  fi
}

addtask arm_mach_types after do_patch before do_configure

S = "${WORKDIR}/git"

KERNEL_IMAGETYPE ?= "uImage"
