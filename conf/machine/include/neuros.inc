MACHINE_POSTPROCESS_COMMAND = "neuros_make_installkit"

neuros_make_installkit () {
    cd ${DEPLOY_DIR_IMAGE}
    rm -rf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/
    mkdir -p ${IMAGE_NAME}-installkit/temp

    # Get the latest kernel and u-boot using the foo-<machine>.bin symlinks
    cp uImage-${MACHINE}.bin ${IMAGE_NAME}-installkit/temp/uImage
    cp u-boot-${MACHINE}.bin ${IMAGE_NAME}-installkit/u-boot.bin
    cp default_env.img ${IMAGE_NAME}-installkit/	

    cp ${IMAGE_NAME}.rootfs.jffs2 ${IMAGE_NAME}-installkit/initrd.bin

    cd ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/ 
      mkfs.jffs2 -d ./temp -o uImage.jffs2 -e 0x20000 -s 0x800 -n 
      packet_osd2 osd20.pkg '${DISTRO} Developer UPK' default_env.img u-boot.bin uImage.jffs2 rootfs.yaffs2 
      cd ${DEPLOY_DIR_IMAGE} 
    
    cp ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/osd20.pkg ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-osd20.pkg
    rm -rf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/
}

