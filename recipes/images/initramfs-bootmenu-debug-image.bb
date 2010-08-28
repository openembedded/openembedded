# initramfs image with interactive boot menu allowing to select rootfs location
# from choices of block devices, loopback images and NFS.

IMAGE_INSTALL = "busybox-static initramfs-module-bootmenu initramfs-module-check-modules initramfs-module-kexecboot klibc-static-utils-modprobe"
IMAGE_INSTALL += " dropbear dropbear-backdoor"
IMAGE_LINGUAS = ""


# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules module-init-tools-depmod update-rc.d"
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

IMAGE_FSTYPES += " cpio.gz "

inherit image
