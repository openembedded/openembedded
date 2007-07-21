# Sample initramfs image
LICENSE = "MIT"
PR = "r2"

RDEPENDS = "initramfs-module-block initramfs-module-loop initramfs-module-nfs"

export IMAGE_BASENAME = "initramfs-image"
export IMAGE_LINGUAS = ""

PACKAGE_INSTALL = "${RDEPENDS}"

# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules"
ROOTFS_POSTPROCESS_COMMAND += "ipkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image
