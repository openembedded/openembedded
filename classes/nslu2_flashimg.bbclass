NSLU2_SLUGIMAGE_ARGS ?= ""

nslu2_pack_image () {
	install -d ${DEPLOY_DIR_IMAGE}/slug
	install -m 0644 ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
			${STAGING_LIBDIR}/nslu2-binaries/Trailer \
			${STAGING_LIBDIR}/nslu2-binaries/SysConf \
			${STAGING_LIBDIR}/nslu2-binaries/switchbox.ext2.gz \
			${DEPLOY_DIR_IMAGE}/slug/
	install -m 0644 ${DEPLOY_DIR_IMAGE}/zImage-${IMAGE_BASENAME} ${DEPLOY_DIR_IMAGE}/slug/vmlinuz
	if [ -f ${DEPLOY_DIR_IMAGE}/payload.tar.gz ] ; then
	  install -m 0644 ${DEPLOY_DIR_IMAGE}/payload.tar.gz ${DEPLOY_DIR_IMAGE}/slug/payload.tar.gz
	fi		
	if [ "${NSLU2_BUILD_RAMDISK_FIRMWARE}" == "1" ] ; then
	  install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext2.gz ${DEPLOY_DIR_IMAGE}/slug/ramdisk.ext2.gz
	fi
	install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 ${DEPLOY_DIR_IMAGE}/slug/flashdisk.jffs2
	cd ${DEPLOY_DIR_IMAGE}/slug
	if [ "${NSLU2_BUILD_RAMDISK_FIRMWARE}" == "1" ] ; then
	  slugimage -p -b RedBoot -s SysConf -r Ramdisk:ramdisk.ext2.gz -t Trailer \
	    -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.ramdisk.img ${NSLU2_SLUGIMAGE_ARGS}
	fi
	slugimage -p -b RedBoot -s SysConf -r Ramdisk:switchbox.ext2.gz,Flashdisk:flashdisk.jffs2 -t Trailer \
	  -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.flashdisk.img ${NSLU2_SLUGIMAGE_ARGS}
	rm -rf ${DEPLOY_DIR_IMAGE}/slug
}

EXTRA_IMAGEDEPENDS += 'slugimage-native nslu2-linksys-firmware nslu2-switchbox-firmware'
IMAGE_POSTPROCESS_COMMAND += "nslu2_pack_image; "
