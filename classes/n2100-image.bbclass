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

IMAGE_POSTPROCESS_COMMAND += "n2100_pack_image; "
