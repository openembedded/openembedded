# Sample initramfs image

#IMAGE_INSTALL = "initramfs-boot busybox kernel-module-uinput uclibc libgcc1"
IMAGE_INSTALL = "initramfs-nfsboot busybox-static kernel-module-uinput"

export IMAGE_BASENAME = "initramfs-image"
IMAGE_LINGUAS = ""

# Install only ${IMAGE_INSTALL}, not even deps
PACKAGE_INSTALL_NO_DEPS = "1"

inherit image
