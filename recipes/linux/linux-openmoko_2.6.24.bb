require linux.inc
require linux-openmoko.inc

SRCREV = "fb42ce6724576fc173faf8abfb04aa2c36d213b7"
PR = "r2"
PR_append = "+gitr${SRCPV}"

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
