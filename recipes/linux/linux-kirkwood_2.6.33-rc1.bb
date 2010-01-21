DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_MACHINE = "openrd-base|openrd-client|sheevaplug"

require linux.inc

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.32+2.6.33-rc1"

SRCREV = "58c19e3ea75a629c3d38a4490f96a65cf2f36a11"

SRC_URI = "git://repo.or.cz/linux-2.6/linux-2.6-openrd.git;protocol=git \
           file://defconfig"

SRC_URI_append_openrd-base += " \
	 file://openrd-base/openrd-base-enable-pcie.patch;patch=1 \
	 file://0004-ARM-Kirkwood-OpenRD-SD-UART1-selection.patch;patch=1 \
	"

SRC_URI_append_openrd-client += " \
	 file://0001-OpenRD-Client-PCIe-Initialize-PCI-express-and-i2c.patch;patch=1 \
	 file://0002-OpenRD-Client-Volari-Z11-driver-added.patch;patch=1 \
	 file://0003-ARM-Kirkwood-Sound-Sound-driver-added.patch;patch=1 \
	 file://0004-ARM-Kirkwood-OpenRD-SD-UART1-selection.patch;patch=1 \
	"

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

