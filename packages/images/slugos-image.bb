# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Generic SlugOS image"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r46"

COMPATIBLE_MACHINE = "nslu2"

IMAGE_NAME = "${IMAGE_BASENAME}-${DISTRO_VERSION}"
IMAGE_FSTYPES = "jffs2"
EXTRA_IMAGECMD_jffs2 += " -D ${SLUGOS_DEVICE_TABLE}"
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

SLUGOS_EXTRA_INSTALL ?= ""

DEPENDS = "task-slugos"
RDEPENDS = "task-slugos ${SLUGOS_EXTRA_INSTALL}"

PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

#NOTE: you do not actually need the boot loader in normal use because it is
# *not* overwritten by a standard upslug upgrade, so you can make an image with
# just non-LinkSys software which can be flashed into the NSLU2.  Because
# LinkSys have made "EraseAll" available, however, (this does overwrite RedBoot)
# it is a bad idea to produce flash images without a valid RedBoot - that allows
# an innocent user upgrade attempt to instantly brick the NSLU2.

IMAGE_POSTPROCESS_COMMAND += "slugos_pack_image;"
EXTRA_IMAGEDEPENDS += "slugimage-native nslu2-linksys-firmware ixp4xx-npe upslug2-native"
NSLU2_SLUGIMAGE_ARGS ?= ""

slugos_pack_image() {
	install -d ${DEPLOY_DIR_IMAGE}/slug
	install -m 0644 ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
			${STAGING_LIBDIR}/nslu2-binaries/Trailer \
			${STAGING_LIBDIR}/nslu2-binaries/SysConf \
			${DEPLOY_DIR_IMAGE}/slug/
	install -m 0644 ${DEPLOY_DIR_IMAGE}/zImage-nslu2${SITEINFO_ENDIANESS} \
		${DEPLOY_DIR_IMAGE}/slug/vmlinuz
	install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		${DEPLOY_DIR_IMAGE}/slug/flashdisk.jffs2
	install -m 0644 ${STAGING_FIRMWARE_DIR}/NPE-B ${DEPLOY_DIR_IMAGE}/slug/
	cd ${DEPLOY_DIR_IMAGE}/slug
	slugimage -p -b RedBoot -s SysConf -k vmlinuz \
		-r Ramdisk:1,Flashdisk:flashdisk.jffs2 -m NPE-B -t Trailer \
		-o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-nslu2.bin \
		${NSLU2_SLUGIMAGE_ARGS}
	rm -rf ${DEPLOY_DIR_IMAGE}/slug

	# Create an image for the DSM-G600 as well
	install -d ${DEPLOY_DIR_IMAGE}/firmupgrade
	install -m 0755 ${DEPLOY_DIR_IMAGE}/zImage-dsmg600${SITEINFO_ENDIANESS} \
		${DEPLOY_DIR_IMAGE}/firmupgrade/ip-ramdisk
	install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		${DEPLOY_DIR_IMAGE}/firmupgrade/rootfs.gz
	touch ${DEPLOY_DIR_IMAGE}/firmupgrade/usr.cramfs
	chmod 0644 ${DEPLOY_DIR_IMAGE}/firmupgrade/usr.cramfs
	echo "hwid=1.0.1"      >${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo "model=dsm-g600" >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo "vendor=dlink"   >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo ""               >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	chmod 0744 ${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	tar -c -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-dsmg600.bin \
		-C ${DEPLOY_DIR_IMAGE} firmupgrade
	rm -rf ${DEPLOY_DIR_IMAGE}/firmupgrade

	# Create an image for the NAS 100d as well
	install -d ${DEPLOY_DIR_IMAGE}/firmupgrade
	install -m 0755 ${DEPLOY_DIR_IMAGE}/zImage-nas100d${SITEINFO_ENDIANESS} \
		${DEPLOY_DIR_IMAGE}/firmupgrade/ip-ramdisk
	install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		${DEPLOY_DIR_IMAGE}/firmupgrade/rootfs.gz
	touch ${DEPLOY_DIR_IMAGE}/firmupgrade/usr.cramfs
	chmod 0644 ${DEPLOY_DIR_IMAGE}/firmupgrade/usr.cramfs
	echo "hwid=1.0.1"      >${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo "model=koala"    >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo "vendor=iomega"  >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo ""               >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	chmod 0744 ${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	tar -c -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-nas100d.bin \
		-C ${DEPLOY_DIR_IMAGE} firmupgrade
	rm -rf ${DEPLOY_DIR_IMAGE}/firmupgrade
}
