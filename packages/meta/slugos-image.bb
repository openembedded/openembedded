# This describes a generic NSLU2 image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
LICENSE = "MIT"
PR = "r17"
PROVIDES += "${SLUGOS_IMAGENAME}-image"

# SLUGOS_IMAGENAME defines the name of the image to be build, if it
# is not set this package will be skipped!
IMAGE_BASENAME = "${SLUGOS_IMAGENAME}"
IMAGE_FSTYPES = "jffs2"

# Kernel suffix - 'nslu2be' or 'nslu2le' for a truely generic image,
# override in the DISTRO configuration if patches or defconfig are
# changed for the DISTRO!
N2K_SUFFIX ?= "nslu2${ARCH_BYTE_SEX}"

#FIXME: this is historical, there should be a minimal slugos device table and
# this stuff shouldn't be in here at all (put it in slugos-image.bb!)
# Why have anything in the config file to control the image build - why not
# just select a different image .bb file (e.g. slugos-ramdisk-image.bb) to
# build with different options.
# IMAGE_SEX = "${@['big-endian', 'little-endian'][bb.data.getVar('ARCH_BYTE_SEX', d, 1) == 'le']}"
SLUGOS_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-slugos.txt')}"
EXTRA_IMAGECMD_jffs2 = "--pad --big-endian --eraseblock=0x20000 -D ${SLUGOS_DEVICE_TABLE}"

# IMAGE_PREPROCESS_COMMAND is run before making the image.  In SlugOS the
# kernel image is removed from the root file system to recover the space used -
# SlugOS is assumed to boot from a separate kernel image in flash (not in the
# root file system), if this is not the case the following must not be done!
IMAGE_PREPROCESS_COMMAND = "rm ${IMAGE_ROOTFS}/boot/zImage*;"

# Building a full image.  If required do a post-process command which builds
# the full image using slugimage.
#
#NOTE: you do not actually need the boot loader in normal use because it is
# *not* overwritten by a standard upslug upgrade, so you can make an image with
# just non-LinkSys software which can be flashed into the NSLU2.  Because
# LinkSys have made "EraseAll" available, however, (this does overwrite RedBoot)
# it is a bad idea to produce flash images without a valid RedBoot - that allows
# an innocent user upgrade attempt to instantly brick the NSLU2.
NSLU2_SLUGIMAGE_ARGS ?= ""

nslu2_pack_image() {
	if test '${SLUGOS_FLASH_IMAGE}' = yes
	then
		install -d ${DEPLOY_DIR_IMAGE}/slug
		install -m 0644 ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
				${STAGING_LIBDIR}/nslu2-binaries/Trailer \
				${STAGING_LIBDIR}/nslu2-binaries/SysConf \
				${DEPLOY_DIR_IMAGE}/slug/
		install -m 0644 ${DEPLOY_DIR_IMAGE}/zImage-${N2K_SUFFIX} \
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

IMAGE_POSTPROCESS_COMMAND += "nslu2_pack_image;"

SLUGOS_IMAGE_DEPENDS = "${@['', 'slugimage-native nslu2-linksys-firmware'][bb.data.getVar('SLUGOS_FLASH_IMAGE', d, 1) == 'yes']}"

IMAGE_LINGUAS = ""
# Setting USE_DEVFS prevents *any* entries being created initially
# in /dev
USE_DEVFS = "1"

# CONFIG:
# SLUGOS_IMAGE_DEPENDS:  set above, do not change
# SLUGOS_EXTRA_RDEPENDS: set in conf, things to add to the image
# SLUGOS_EXTRA_DEPENDS:  set in conf, things to build, not added
#                        to the image.
# SLUGOS_NATIVE_DEPENDS: set in conf, things to build, intended
#                        for native (run-on-host) tools
#
# SLUGOS_SUPPORT:        set to here, see below, added to build and
#                        to the image.
# SLUGOS_KERNEL:         set here, kernel modules added to the image
#
# Do not override the last two unless you really know what you
# are doing - there is more information below.

# diff, cpio and find are required for reflash and turnup ram.
# Removing these probably leaves the system bootable, but standard
# openslug and ucslugc stuff won't work, so only take these out in
# very non-standard turnkey ucslugc builds.
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
       
# The things explicitly included in the following lists are the
# absolute minimum to have any chance of a bootable system.
DEPENDS = "${SLUGOS_IMAGE_DEPENDS} \
	virtual/kernel base-files base-passwd \
        busybox dropbear hotplug-ng initscripts-slugos netbase \
        sysvinit tinylogin portmap \
        virtual/ixp-eth slugos-init \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	${SLUGOS_SUPPORT} \
        ${SLUGOS_EXTRA_DEPENDS} \
	${SLUGOS_NATIVE_DEPENDS}"

IPKG_INSTALL = "base-files base-passwd \
        busybox dropbear hotplug-ng initscripts-slugos netbase \
        update-modules sysvinit tinylogin portmap \
        ${PREFERRED_PROVIDER_virtual/ixp-eth} slugos-init \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	${SLUGOS_SUPPORT} \
	${SLUGOS_KERNEL} \
	${SLUGOS_EXTRA_RDEPENDS}"

inherit image_ipk

python () {
	# Don't build slugos images unless the configuration is set up
	# for an image build!
	if bb.data.getVar("SLUGOS_IMAGENAME", d, 1) == '':
		raise bb.parse.SkipPackage("absent or broken SlugOS configuration")
}
