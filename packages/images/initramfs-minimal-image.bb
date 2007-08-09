# Sample initramfs image
LICENSE = "MIT"
PR = "r0"

#RDEPENDS = "initramfs-boot busybox kernel-module-uinput uclibc libgcc1"
RDEPENDS = "initramfs-nfsboot busybox-static kernel-module-uinput"

export IMAGE_BASENAME = "initramfs-image"
export IMAGE_LINGUAS = ""

PACKAGE_INSTALL = "${RDEPENDS}"
# Install only ${PACKAGE_INSTALL}, not even deps
PACKAGE_INSTALL_NO_DEPS = "1"

inherit image
