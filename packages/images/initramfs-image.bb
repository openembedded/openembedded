# Sample initramfs image
LICENSE = "MIT"
PR = "r1"

#RDEPENDS = "initramfs-boot busybox kernel-module-uinput uclibc libgcc1"
RDEPENDS = "initramfs initramfs-module-nfs initramfs-module-loop \
            busybox-static"

RRECOMENDS = "kernel-module-uinput kernel-module-fat \
              kernel-module-vfat kernel-module-loop"

export IMAGE_BASENAME = "initramfs-image"
export IMAGE_LINGUAS = ""

PACKAGE_INSTALL = "${RDEPENDS}"
# Install only ${PACKAGE_INSTALL}, not even deps
PACKAGE_INSTALL_NO_DEPS = "1"

inherit image
