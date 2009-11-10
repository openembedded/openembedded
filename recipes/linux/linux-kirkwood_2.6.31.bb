DESCRIPTION = "Linux Kernel for Marvell Kirkwood based devices"
SECTION = "kernel"
LICENSE = "GPL"

COMPATIBLE_MACHINE = "openrd-base"

# SheevaPlug still needs testing
#COMPATIBLE_MACHINE = "(openrd-base|sheevaplug)"

require linux.inc

FILESPATHPKG_prepend = "linux-2.6.31:"

# Change MACHINE_KERNEL_PR in conf/machine/include/kirkwood.inc
PV = "2.6.31"

# last commit at the time of release of upstream v2.6.31
SRCREV = "8cb424312d88810bb62edbeef42a510725ceb482"

SRC_URI = "git://git.marvell.com/orion.git;protocol=git \
           file://defconfig"

SRC_URI_append_openrd-base = " file://openrd-base-enable-pcie.patch;patch=1 \
                               file://cpuidle-reenable-interrupts.patch;patch=1 \
                               file://0001-Squashfs-move-zlib-decompression-wrapper-code-into.patch;patch=1 \
                               file://0002-Squashfs-Factor-out-remaining-zlib-dependencies-int.patch;patch=1 \
                               file://0003-Squashfs-add-a-decompressor-framework.patch;patch=1 \
                               file://0004-Squashfs-add-decompressor-entries-for-lzma-and-lzo.patch;patch=1 \
                               file://0005-Squashfs-add-an-extra-parameter-to-the-decompressor.patch;patch=1 \
                               file://0006-Squashfs-add-LZMA-compression.patch;patch=1 \
                               file://0007-Squashfs-Make-unlzma-available-to-non-initramfs-ini.patch;patch=1 \
                             "
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
