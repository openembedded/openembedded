# micro-image-visstrim
#
# This image is based on micro-image and contains basic packages that are needed
# to boot Visstrim_M10 boards and use jffs2+squashfs power cut safe schema.
#
# The image is tested to build and run succesfully with the following machines:
#
#	* visstrim_m10
#
# Maintainer: Javier Martin <javier.martin@vista-silicon.com>
#

DISTRO_SSH_DAEMON ?= "dropbear"

# Install basic files only
IMAGE_INSTALL = "base-files \
		 visstrim-m10-utils \
		 base-passwd \
		 netbase \
                 u-boot-utils \
		 ${DISTRO_SSH_DAEMON}"

IMAGE_LINGUAS = ""

# Use busybox as login manager
IMAGE_LOGIN_MANAGER = "busybox"

# Include minimum init and init scripts
IMAGE_DEV_MANAGER = ""
IMAGE_INIT_MANAGER = "sysvinit sysvinit-pidof"
IMAGE_INITSCRIPTS = ""

inherit image

fso_rootfs_postprocess() {
	curdir=$PWD
	cd ${DEPLOY_DIR_IMAGE}
	mkdir -p tmp/config0
	mkdir -p tmp/config1
	cp -a ${IMAGE_ROOTFS}/etc tmp/config0/
	cp -a ${IMAGE_ROOTFS}/etc tmp/config1/
	mkfs.jffs2 -r ./tmp -s 0x800 -e 0x20000 -o ${MACHINE}-config.jffs2 --pad=0x200000
	rm -rf ./tmp
	cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "fso_rootfs_postprocess"

