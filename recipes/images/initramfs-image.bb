# initramfs image allowing to boot from location as specified on kernel
# command line, from teh choices of block device, loop back images (including
# recursive) and NFS.

IMAGE_INSTALL = "busybox-static initramfs-module-block initramfs-module-loop initramfs-module-nfs"
IMAGE_FSTYPES = "cpio.gz"
IMAGE_LINGUAS = ""

# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules"
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image
