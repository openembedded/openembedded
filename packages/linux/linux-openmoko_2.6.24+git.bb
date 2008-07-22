require linux.inc
require linux-openmoko.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for FIC SmartPhones shipping w/ Openmoko"

KERNEL_RELEASE = "2.6.24"
KERNEL_VERSION = "${KERNEL_RELEASE}"

PV = "${KERNEL_RELEASE}+gitr${SRCREV}"
PR = "r4"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=stable \
  \
  file://0001-squashfs-with-lzma.patch;patch=1 \
  file://0002-squashfs-initrd.patch;patch=1 \
  file://0003-squashfs-force-O2.patch;patch=1 \
  file://0004-squashfs-Kconfig.patch;patch=1 \
  file://0005-squashfs-Makefile.patch;patch=1 \
  \
  file://defconfig-oe \
"
S = "${WORKDIR}/git"
