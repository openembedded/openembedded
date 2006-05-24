# we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND = "rm -f ${IMAGE_ROOTFS}/tmp/zImage*"

# create a tar.gz (.imgz) file containing the filesystem and the kernel
nylon_create_imgz() {
	rm -rf ${DEPLOY_DIR_IMAGE}/tmp
	rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.imgz
	install -d ${DEPLOY_DIR_IMAGE}/tmp
	
	cp ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.flash.bin ${DEPLOY_DIR_IMAGE}/tmp/zImage.flash
	cp ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.${type} ${DEPLOY_DIR_IMAGE}/tmp/rootfs.${type}
	( cd ${DEPLOY_DIR_IMAGE}/tmp; tar cvzf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.imgz * )
	rm -r ${DEPLOY_DIR_IMAGE}/tmp
}

IMAGE_POSTPROCESS_COMMAND += "nylon_create_imgz;"
