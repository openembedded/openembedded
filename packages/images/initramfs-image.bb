# Sample initramfs image

IMAGE_INSTALL = "initramfs-module-block initramfs-module-loop initramfs-module-nfs"
IMAGE_LINGUAS = ""

# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules"
ROOTFS_POSTPROCESS_COMMAND += "ipkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image
