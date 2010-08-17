# this image was created for use with the BeagleBoard for diagnostics
# for creating a small ramdisk image

require minimal-image.bb

IMAGE_INSTALL += " \
  dosfstools \
  e2fsprogs \
  e2fsprogs-mke2fs \
  mtd-utils \
  alsa-utils \
  alsa-utils-aplay \
  mplayer \
  memtester \
  evtest \
  i2c-tools \
  cpufrequtils \
  angstrom-uboot-scripts \
  beagleboard-test-scripts \
  nano \
  cpuburn-neon \
  kernel-module-mt9t112 \
  kernel-module-g-ether \
  u-boot-mkimage \
  sox \
  devmem2 \
  ti-dsplink-examples \
"

export IMAGE_BASENAME = "beagleboard-test-image"

EXTRA_IMAGEDEPENDS += "x-load u-boot virtual/kernel"
IMAGE_FSTYPES += "ext2.gz cpio.gz.u-boot"
IMAGE_ROOTFS_SIZE_ext2 = "131072"
EXTRA_IMAGECMD_ext2.gz += "-i 8192"

