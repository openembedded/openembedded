magicbox_gen_images() {
        # find latest kernel
        KERNEL=`ls -tr ${DEPLOY_DIR_IMAGE}/uImage* | tail -n 1`
        if [ -z "$KERNEL" ]; then
                oefatal "No kernel found in ${DEPLOY_DIR_IMAGE}. Exiting !"
                exit 1
        fi

        #squashfs
        #We need to prep the image so that u-boot recognizes it
         mv ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.squashfs ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.squashfs.bin
         ${STAGING_BINDIR_NATIVE}/mkimage -A ppc -O linux -T ramdisk -C none -n "OPLinux-uclibc-squashfs"  \
                -d ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.squashfs.bin ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.squashfs
         rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.squashfs.bin


        #squashfs-lzma
        #same as squashfs
         mv ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.squashfs-lzma ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.squashfs-lzma.bin
         ${STAGING_BINDIR_NATIVE}/mkimage -A ppc -O linux -T ramdisk -C none -n "OPLinux-uclibc-squashfs-lzma"  \
           -d ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.squashfs-lzma.bin ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.squashfs-lzma
         rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.squashfs-lzma.bin

        #kernel+jffs2 in a single image
        #Add jffs2 marker at the end of the rootfs file
        echo -ne '\xde\xad\xc0\xde' >> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2

       
        ( dd if=$KERNEL bs=65536 conv=sync; \ 
        dd if=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 bs=65536 conv=sync; \
        ) >  ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.jffs2.flash.bin

}



IMAGE_POSTPROCESS_COMMAND += "magicbox_gen_images; "
