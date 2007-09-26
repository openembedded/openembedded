# LiveRamdisk image
# Building with ANGSTROM_MODE=uclibc is recommended
#
# LiveRamdisk concept/implementation by Paul Sokolovsky
LICENSE = "MIT"
IMAGE_FSTYPES = "cpio.gz"

#IMAGE_INSTALL = "initramfs-boot busybox kernel-module-uinput uclibc libgcc1"
IMAGE_INSTALL = "initramfs-jffs2 busybox-static kernel-module-mtdram"

export IMAGE_BASENAME = "liveramdisk"
export IMAGE_LINGUAS = ""

# Install only ${IMAGE_INSTALL}, not even deps
PACKAGE_INSTALL_NO_DEPS = "1"

inherit image
