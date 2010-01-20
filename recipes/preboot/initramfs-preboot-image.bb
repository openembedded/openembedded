#initramfs image which mounts the rootfilesystem and kexecs a kernel from there
PR = "r1"

ONLINE_PACKAGE_MANAGEMENT = "none"
IMAGE_FSTYPES = "cpio.gz"

export IMAGE_BASENAME = "initramfs-preboot-image"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

IMAGE_INSTALL = " \
	task-boot \
	util-linux-ng-mount util-linux-ng-umount \
	dropbear \
	fontconfig \
	ttf-freefonts \
	eina \
	evas \
	edje \
	efreet \
	eet \
	edbus \
	elementary \
	elementary-themes \
	elementary-tests \
	fbset \
	fbset-init \
    msmcommd \
#	lvm2 \
#	preboot \
	"

IMAGE_LINGUAS = ""

inherit image

preboot_palmpre_rootfs_postprocess() {
	# copy all our files to the rootfs
	dirs=`find ${FILESDIR} -type d -printf "%P\n" | grep -v "^.$" | grep -v ".git"`
	for dir in $dirs; do
		mkdir -p ${IMAGE_ROOTFS}/$dir
	done
	files=`find ${FILESDIR} -type f -printf "%P\n" | grep -v ".git"`
	for file in $files; do
		cp -f ${FILESDIR}/$file ${IMAGE_ROOTFS}/$file
	done

	curdir=$PWD
	cd ${IMAGE_ROOTFS}

	# install our usbnet initscript
	chmod +x etc/init.d/usbnet
#	ln -sf ../init.d/usbnet ${IMAGE_ROOTFS}/etc/rcS.d/S15usbnet

	# miniboot sequence (just for debugging)
	rm ${IMAGE_ROOTFS}/sbin/init
	chmod +x ${IMAGE_ROOTFS}/etc/miniboot.sh 
	ln -sf /etc/miniboot.sh ${IMAGE_ROOTFS}/init
	ln -sf ../etc/miniboot.sh ${IMAGE_ROOTFS}/sbin/init

	cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND_palmpre += " preboot_palmpre_rootfs_postprocess"


