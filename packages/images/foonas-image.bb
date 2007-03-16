DESCRIPTION = "Foonas image"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "${MACHINE_TASK_PROVIDER}"
EXTRA_IMAGECMD_turbostation = "--big-endian"
EXTRA_IMAGECMD_n2100 = "--little-endian"
EXTRA_IMAGECMD_jffs2 += " --eraseblock=${ERASEBLOCK_SIZE} -D ${SLUGOS_DEVICE_TABLE}"
IMAGE_LINGUAS = ""

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
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^id:5:initdefault:,id:3:initdefault:, ${IMAGE_ROOTFS}/etc/inittab;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^root::0,root:BTMzOOAQfESg6:0, ${IMAGE_ROOTFS}/etc/passwd;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^VERBOSE=no,VERBOSE=very, ${IMAGE_ROOTFS}/etc/default/rcS;"

# Always just make a new flash image.
PACK_IMAGE = '${MACHINE}_pack_image;'
IMAGE_POSTPROCESS_COMMAND += "${PACK_IMAGE}"
PACK_IMAGE_DEPENDS = ""
#EXTRA_IMAGEDEPENDS += "${PACK_IMAGE_DEPENDS}"

# These depends define native utilities - they do not get put in the flash and
# are not required to build the image.
IMAGE_TOOLS = ""
#EXTRA_IMAGEDEPENDS += "${IMAGE_TOOLS}"

FOONAS_SUPPORT += "diffutils cpio findutils udev"
FOONAS_SUPPORT_turbostation += "uboot-utils"

# this gets /lib/modules made....
FOONAS_KERNEL_turbostation = "kernel-module-ext3 kernel-module-minix \
			kernel-module-usb-storage"

FOONAS_KERNEL_n2100 = "kernel-module-ext2 kernel-module-usb-storage"

RDEPENDS = " \
	base-files base-passwd netbase \
        busybox initscripts foonas-init \
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
	udev \
	${FOONAS_SUPPORT} \
	${FOONAS_KERNEL} "

PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

# At this point you have to make a ${MACHINE}_pack_image for your machine.

turbostation_pack_image() {
	# find latest kernel
	KERNEL=`ls -tr ${DEPLOY_DIR_IMAGE}/uImage* | tail -1`
	if [ -z "$KERNEL" ]; then
		oefatal "No kernel found in ${DEPLOY_DIR_IMAGE}. Bitbake linux-turbostation to create one."
		exit 1
	fi
	ROOTFS=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2
	OUTPUT=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.flash.img
	PADFILE=${DEPLOY_DIR_IMAGE}/padfile.zzz
	HEX_MAX_KERN_SIZE=200000
	DEC_MAX_KERN_SIZE=`echo "ibase=16; $HEX_MAX_KERN_SIZE" | bc `
	HEX_MAX_ROOT_SIZE=D00000
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

n2100_pack_image() {
        # find latest kernel
        KERNEL=`ls -tr ${DEPLOY_DIR_IMAGE}/zImage* | tail -1`
        if [ -z "$KERNEL" ]; then
                oefatal "No kernel found in ${DEPLOY_DIR_IMAGE}. Bitbake linux to create one."
                exit 1
        fi
        ROOTFS=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2
        OUTPUT=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.flash.img
        PADFILE=${DEPLOY_DIR_IMAGE}/padfile.zzz
        HEX_MAX_KERN_SIZE=1C0000
        DEC_MAX_KERN_SIZE=`echo "ibase=16; $HEX_MAX_KERN_SIZE" | bc `
        HEX_MAX_ROOT_SIZE=DC0000
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