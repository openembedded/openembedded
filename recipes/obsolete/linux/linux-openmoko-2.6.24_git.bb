require linux.inc
require linux-openmoko.inc

KERNEL_RELEASE = "2.6.24"
KERNEL_VERSION = "${KERNEL_RELEASE}"

SRCREV = "fb42ce6724576fc173faf8abfb04aa2c36d213b7"
OEV = "oe5"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"
PR = "r1"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=stable \
  \
  file://0001-squashfs-with-lzma.patch \
  file://0002-squashfs-initrd.patch \
  file://0003-squashfs-force-O2.patch \
  file://0004-squashfs-Kconfig.patch \
  file://0005-squashfs-Makefile.patch \
  \
  file://openwrt-ledtrig-netdev.patch \
  file://gta01-fix-battery-class-name.patch \
  \
  file://defconfig-oe \
"
S = "${WORKDIR}/git"
