# Sample initramfs image

IMAGE_INSTALL = "busybox-static initramfs-module-bootmenu"
IMAGE_LINGUAS = ""

# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules module-init-tools-depmod uclibc update-rc.d"
ROOTFS_POSTPROCESS_COMMAND += "ipkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image
