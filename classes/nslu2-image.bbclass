nslu2_pack_image () {
	slugimage -p \
		-b ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
		-s ${STAGING_LIBDIR}/nslu2-binaries/SysConf \
		-k ${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin \
		-L ${STAGING_LOADER_DIR}/apex-nslu2.bin \
		-r Flashdisk:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		-m ${STAGING_FIRMWARE_DIR}/NPE-B \
		-t ${STAGING_LIBDIR}/nslu2-binaries/Trailer \
		-o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-nslu2.bin
	slugimage -F -p \
		-b ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
		-s ${STAGING_LIBDIR}/nslu2-binaries/SysConf \
		-k ${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin \
		-L ${STAGING_LOADER_DIR}/apex-nslu2-16mb.bin \
		-r Flashdisk:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		-m ${STAGING_FIRMWARE_DIR}/NPE-B \
		-t ${STAGING_LIBDIR}/nslu2-binaries/Trailer \
		-o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-nslu2-16mb.bin
}

EXTRA_IMAGEDEPENDS += 'slugimage-native nslu2-linksys-firmware ixp4xx-npe apex-nslu2 apex-nslu2-16mb'
IMAGE_POSTPROCESS_COMMAND += "nslu2_pack_image; "
