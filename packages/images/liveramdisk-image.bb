# LiveRamdisk image
# Hwo to build:
# First build angstrom-x11-image with glibc
# then switch to ANGSTROM_MODE=uclibc and build this recipe
# LiveRamdisk concept/implementation by Paul Sokolovsky
LICENSE = "MIT"
IMAGE_FSTYPES = "cpio.gz"

#IMAGE_INSTALL = "initramfs-boot busybox kernel-module-uinput uclibc libgcc1"
IMAGE_INSTALL = "initramfs-jffs2 busybox-static kernel-module-mtdram"

export IMAGE_BASENAME = "liveramdisk"
export IMAGE_LINGUAS = ""

# Install only ${IMAGE_INSTALL}, not even deps
PACKAGE_INSTALL_NO_DEPS = "1"

inherit image

IMAGE_PREPROCESS_COMMAND += " copy_jffs2_image; "

copy_jffs2_image() {
	# We need glibc main image
	latest_image=`ls -1 -r ${DEPLOY_DIR}/../glibc/images/${MACHINE}/Angstrom-x11-image-glibc-*.rootfs.jffs2|head -n1`
	[ -n "$latest_image" ] || oefatal "Cannot find jffs2 image in ${DEPLOY_DIR}/../glibc/images/${MACHINE}/"
	oenote "Using: cp $latest_image ${IMAGE_ROOTFS}/initrd.jffs2"
	cp $latest_image ${IMAGE_ROOTFS}/initrd.jffs2
}
