# we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND = "rm -f ${IMAGE_ROOTFS}/tmp/*Image*"

# create a tar.gz (.imgz) file containing the filesystem and the kernel
nylon_create_imgz() {
	rm -rf ${DEPLOY_DIR_IMAGE}/tmp
	rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.imgz
	install -d ${DEPLOY_DIR_IMAGE}/tmp
	
        # copy the kernel (for mips on flash) into tmp  
        FLASH_BIN=${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.flash.bin  
        test -f ${FLASH_BIN} && \ 
        cp ${FLASH_BIN} ${DEPLOY_DIR_IMAGE}/tmp/zImage.flash 
 
        # copy rootfs.jffs (or so) into tmp 
	cp ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.${type} ${DEPLOY_DIR_IMAGE}/tmp/rootfs.${type}

	# make an imgz out of tmp
	( cd ${DEPLOY_DIR_IMAGE}/tmp; tar cvzf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.imgz * )
	rm -r ${DEPLOY_DIR_IMAGE}/tmp
}

IMAGE_POSTPROCESS_COMMAND += "nylon_create_imgz;"
