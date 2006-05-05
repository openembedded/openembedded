# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Generic SlugOS image"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r28"

# SLUGOS_IMAGENAME defines the name of the image to be build, if it
# is not set this package will be skipped!
IMAGE_BASENAME = "${SLUGOS_IMAGENAME}"
IMAGE_FSTYPES = "jffs2"
EXTRA_IMAGECMD_jffs2 = "--pad --${SLUGOS_IMAGESEX} --eraseblock=0x20000 -D ${SLUGOS_DEVICE_TABLE}"
IMAGE_LINGUAS = ""

# Setting USE_DEVFS prevents *any* entries being created initially
# in /dev
USE_DEVFS = "1"

# This is passed to the image command to build the correct /dev
# directory (because only the image program can make actual
# dev entries!)
SLUGOS_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-slugos.txt')}"

# IMAGE_PREPROCESS_COMMAND is run before making the image.  In SlugOS the
# kernel image is removed from the root file system to recover the space used -
# SlugOS is assumed to boot from a separate kernel image in flash (not in the
# root file system), if this is not the case the following must not be done!
IMAGE_PREPROCESS_COMMAND += "rm ${IMAGE_ROOTFS}/boot/zImage*;"
IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${SLUGOS_DEVICE_TABLE} ${IMAGE_ROOTFS}/etc/device_table;"

# Building a full image.  If required do a post-process command which builds
# the full flash image using slugimage.  At present this only works for NSLU2 images.
PACK_IMAGE = ""
IMAGE_POSTPROCESS_COMMAND += "${PACK_IMAGE}"
PACK_IMAGE_DEPENDS = ""
EXTRA_IMAGEDEPENDS += "${PACK_IMAGE_DEPENDS}"

# This hack removes '${MACHINE}' from the end of the arch.conf for ipk,
# preventing _mach.ipk (with no byte sex) taking precedence over everything
# else.
ROOTFS_POSTPROCESS_COMMAND += "sed -i '$d' '${IMAGE_ROOTFS}/etc/ipkg/arch.conf';"

# These depends define native utilities - they do not get put in the flash and
# are not required to build the image.
IMAGE_TOOLS = ""
EXTRA_IMAGEDEPENDS += "${IMAGE_TOOLS}"

# CONFIG:
# SLUGOS_EXTRA_RDEPENDS: set in conf, things to add to the image
# SLUGOS_SUPPORT:        set to here, see below, added to the image.
# SLUGOS_KERNEL:         set here, kernel modules added to the image
#
# Do not override the last two unless you really know what you
# are doing - there is more information below.

# diff, cpio and find are required for reflash and turnup ram.
# Removing these probably leaves the system bootable, but standard
# openslug and ucslugc stuff won't work, so only take these out in
# very non-standard turnkey slugos builds.
#
# udev is the default way of handling devices, there is no guarantee
# that the static device table is completely correct (it is just
# known to be sufficient for boot.)
SLUGOS_SUPPORT ?= "diffutils cpio findutils udev"

# kernel-module-af-packet must be in the image for DHCP to work
# kernel-module-netconsole is here because it is small and is
# highly useful on minimal systems (which really don't have anywhere
# other than the network to output error messages!)
SLUGOS_KERNEL ?= "kernel-module-af-packet kernel-module-netconsole"
       
RDEPENDS = "kernel ixp-eth \
	base-files base-passwd netbase \
        busybox hotplug-ng initscripts-slugos slugos-init \
        update-modules sysvinit tinylogin \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	portmap \
	dropbear \
	beep \
	e2fsprogs-blkid \
	util-linux-mount \
	util-linux-umount \
	util-linux-swaponoff \
	util-linux-losetup \
	${SLUGOS_SUPPORT} \
	${SLUGOS_KERNEL} \
	${SLUGOS_EXTRA_RDEPENDS}"

IPKG_INSTALL = "${RDEPENDS}"

inherit image_ipk

python () {
	# Don't build slugos images unless the configuration is set up
	# for an image build!
	if bb.data.getVar("SLUGOS_IMAGENAME", d, 1) == '' or bb.data.getVar("SLUGOS_IMAGESEX", d, 1) == '':
		raise bb.parse.SkipPackage("absent or broken SlugOS configuration")
}

#--------------------------------------------------------------------------------
# NSLU2 specific
#
#NOTE: you do not actually need the boot loader in normal use because it is
# *not* overwritten by a standard upslug upgrade, so you can make an image with
# just non-LinkSys software which can be flashed into the NSLU2.  Because
# LinkSys have made "EraseAll" available, however, (this does overwrite RedBoot)
# it is a bad idea to produce flash images without a valid RedBoot - that allows
# an innocent user upgrade attempt to instantly brick the NSLU2.
PACK_IMAGE += "${@['', 'nslu2_pack_image;'][bb.data.getVar('SLUGOS_FLASH_IMAGE', d, 1) == 'yes']}"
PACK_IMAGE_DEPENDS += "${@['', 'slugimage-native nslu2-linksys-firmware'][bb.data.getVar('SLUGOS_FLASH_IMAGE', d, 1) == 'yes']}"

NSLU2_SLUGIMAGE_ARGS ?= ""

nslu2_pack_image() {
	if test '${SLUGOS_FLASH_IMAGE}' = yes
	then
		install -d ${DEPLOY_DIR_IMAGE}/slug
		install -m 0644 ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
				${STAGING_LIBDIR}/nslu2-binaries/Trailer \
				${STAGING_LIBDIR}/nslu2-binaries/SysConf \
				${DEPLOY_DIR_IMAGE}/slug/
		install -m 0644 ${DEPLOY_DIR_IMAGE}/zImage-nslu2${ARCH_BYTE_SEX} \
			${DEPLOY_DIR_IMAGE}/slug/vmlinuz
		install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
			${DEPLOY_DIR_IMAGE}/slug/flashdisk.jffs2
		cd ${DEPLOY_DIR_IMAGE}/slug
		slugimage -p -b RedBoot -s SysConf -r Ramdisk:1,Flashdisk:flashdisk.jffs2 -t \
			Trailer -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.flashdisk.img \
			${NSLU2_SLUGIMAGE_ARGS}
		rm -rf ${DEPLOY_DIR_IMAGE}/slug
	fi
}

# upslug2 (in tmp/work/upslug2-native-*) is the program to write the NSLU2 flash
IMAGE_TOOLS_nslu2 = "upslug2-native"
