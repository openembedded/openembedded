# LiveRamdisk image
# Building with ANGSTROMLIBC=uclibc is recommended
#
# LiveRamdisk concept/implementation by Paul Sokolovsky
LICENSE = "MIT"
IMAGE_FSTYPES = "cpio.gz"

#IMAGE_INSTALL = "initramfs-boot busybox kernel-module-uinput uclibc libgcc1"
IMAGE_INSTALL = "initramfs-jffs2 busybox-static kernel-module-mtdram"

export IMAGE_BASENAME = "liveramdisk"
export IMAGE_LINGUAS = ""

# Install only ${IMAGE_INSTALL}, not even deps
#PACKAGE_INSTALL_NO_DEPS = "1"

# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules module-init-tools-depmod uclibc update-rc.d"
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image
