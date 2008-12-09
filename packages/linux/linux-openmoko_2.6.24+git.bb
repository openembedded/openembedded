require linux.inc
require linux-openmoko.inc

DESCRIPTION = "The Linux kernel for the Openmoko devices GTA01 (Neo1973) and GTA02 (Neo FreeRunner)"

KERNEL_RELEASE = "2.6.24"
KERNEL_VERSION = "${KERNEL_RELEASE}"

OEV = "oe2"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=stable \
  \
  file://0001-squashfs-with-lzma.patch;patch=1 \
  file://0002-squashfs-initrd.patch;patch=1 \
  file://0003-squashfs-force-O2.patch;patch=1 \
  file://0004-squashfs-Kconfig.patch;patch=1 \
  file://0005-squashfs-Makefile.patch;patch=1 \
  \
  file://openwrt-ledtrig-netdev.patch;patch=1 \
  \
  file://defconfig-oe \
"
S = "${WORKDIR}/git"
