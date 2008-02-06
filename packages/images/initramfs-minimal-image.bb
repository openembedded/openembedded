# Sample initramfs image, very minimal

IMAGE_INSTALL = "initramfs-module-nfs busybox-static"

export IMAGE_BASENAME = "initramfs-image"
IMAGE_LINGUAS = ""

# Install only ${IMAGE_INSTALL}, not even deps
PACKAGE_INSTALL_NO_DEPS = "1"

inherit image
