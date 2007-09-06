DESCRIPTION = "OpenProtium image"
HOMEPAGE = "http://www.openprotium.com"

DEPENDS = "${MACHINE_TASK_PROVIDER}"
EXTRA_IMAGECMD_jffs2 = "--pad --big-endian --eraseblock=0x10000 -D ${SLUGOS_DEVICE_TABLE}"
IMAGE_LINGUAS = ""

# Setting USE_DEVFS prevents *any* entries being created initially
# in /dev
USE_DEVFS = "1"

# This is passed to the image command to build the correct /dev
# directory (because only the image program can make actual
# dev entries!)
SLUGOS_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-slugos.txt')}"

# IMAGE_PREPROCESS_COMMAND is run before making the image.
# We use this to do a few things:
# . remove the uImage, which is in a separate part of the flash already.
# . adjust the default run level (sysvinit is 5 by default, we like 3)
# . set a default root password, which is no more secure than a blank one
#	(since it is documented, in case you were wondering)
# . make the boot more verbose
#
IMAGE_PREPROCESS_COMMAND += "rm ${IMAGE_ROOTFS}/boot/uImage-*;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^id:5:initdefault:,id:3:initdefault:, ${IMAGE_ROOTFS}/etc/inittab;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^root::0,root:BTMzOOAQfESg6:0, ${IMAGE_ROOTFS}/etc/passwd;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^VERBOSE=no,VERBOSE=very, ${IMAGE_ROOTFS}/etc/default/rcS;"

# Always just make a new flash image.
PACK_IMAGE = 'storcenter_pack_image;'
IMAGE_POSTPROCESS_COMMAND += "${PACK_IMAGE}"
PACK_IMAGE_DEPENDS = ""
#EXTRA_IMAGEDEPENDS += "${PACK_IMAGE_DEPENDS}"

# This hack removes '${MACHINE}' from the end of the arch.conf for ipk,
# preventing _mach.ipk (with no byte sex) taking precedence over everything
# else.
# but we want 'storcenter' in there so kernel modules work correctly.
#
#ROOTFS_POSTPROCESS_COMMAND += "sed -i '$d' '${IMAGE_ROOTFS}/etc/ipkg/arch.conf';"

# These depends define native utilities - they do not get put in the flash and
# are not required to build the image.
IMAGE_TOOLS = ""
#EXTRA_IMAGEDEPENDS += "${IMAGE_TOOLS}"

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
# we'ere still on 2.6.12 devfs....
#OPENPROTIUM_SUPPORT ?= "diffutils cpio findutils udev"
#
OPENPROTIUM_SUPPORT ?= "diffutils cpio findutils uboot-utils"

# kernel-module-af-packet must be in the image for DHCP to work
# kernel-module-netconsole is here because it is small and is
# highly useful on minimal systems (which really don't have anywhere
# other than the network to output error messages!)
SLUGOS_KERNEL ?= "kernel-module-af-packet kernel-module-netconsole \
		kernel-module-mii "

# this gets /lib/modules made....
OPENPROTIUM_KERNEL = "kernel-module-dummy \
			kernel-module-af-packet "

IMAGE_INSTALL = " \
	kernel base-files base-passwd netbase \
        busybox initscripts-openprotium openprotium-init \
        update-modules sysvinit tinylogin \
	module-init-tools-depmod modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	libgcc1 \
	portmap \
	dropbear \
	e2fsprogs-blkid \
	mdadm \
	hdparm \
	mtd-utils \
	${OPENPROTIUM_SUPPORT} \
	${OPENPROTIUM_KERNEL} "
#	${SLUGOS_EXTRA_RDEPENDS}"

inherit image

storcenter_pack_image() {
	# find latest kernel
	KERNEL=`ls -tr ${DEPLOY_DIR_IMAGE}/uImage* | tail -1`
	if [ -z "$KERNEL" ]; then
		oefatal "No kernel found in ${DEPLOY_DIR_IMAGE}. Bitbake linux-storcenter to create one."
		exit 1
	fi
	ROOTFS=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2
	OUTPUT=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.flash.img
	PADFILE=${DEPLOY_DIR_IMAGE}/padfile.zzz
	HEX_MAX_KERN_SIZE=170000
	DEC_MAX_KERN_SIZE=`echo "ibase=16; $HEX_MAX_KERN_SIZE" | bc `
	HEX_MAX_ROOT_SIZE=590000
	DEC_MAX_ROOT_SIZE=`echo "ibase=16; $HEX_MAX_ROOT_SIZE" | bc `
	KERNEL_SIZE=`ls -l $KERNEL | awk '{print $5}'`
	if [ $KERNEL_SIZE -gt $DEC_MAX_KERN_SIZE ]; then
	        oefatal "Kernel too large at $KERNEL_SIZE bytes.  Max is $DEC_MAX_KERN_SIZE."
		exit 1
	fi
	ROOT_SIZE=`ls -l $ROOTFS | awk '{print $5}'`
	if [ $ROOT_SIZE -gt $DEC_MAX_ROOT_SIZE ]; then
		oefatal "Rootfs is too large at $ROOT_SIZE bytes.  Max is $DEC_MAX_ROOT_SIZE."
		exit 1
	fi
	PAD_SIZE=`echo "$DEC_MAX_KERN_SIZE - $KERNEL_SIZE" | bc `
	dd if=/dev/zero of=$PADFILE bs=$PAD_SIZE count=1 2>>/dev/null
	cat $KERNEL $PADFILE $ROOTFS > $OUTPUT
	rm -f $PADFILE
	ls -l $OUTPUT
}
