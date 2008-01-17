
#
# define the FLASH_KERNEL_SIZE and FLASH_ROOT_SIZE in your machine.conf,
# and this class builds a simple, padded concatenated image of 
# <kernel><padding><rootfs> and performs error checking that either
# kernel or rootfs isn't too large to fit.
#
concat_pack_image() {
	# find latest kernel - is there a more general way to do this?
        KERNEL=`ls -tr ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}* | tail -n 1`
	if [ -z "$KERNEL" ]; then
		oefatal "No kernel found in ${DEPLOY_DIR_IMAGE}.  Was expecting a ${KERNEL_IMAGETYPE}\* file."
		exit 1
	fi
	ROOTFS=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2
	OUTPUT=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.flash.img
	PADFILE=${DEPLOY_DIR_IMAGE}/padfile.zzz
	KERNEL_SIZE_MAX_DEC=`echo ${FLASH_KERNEL_SIZE} | awk --non-decimal-data '{printf "%d\n", $1}' `
	ROOT_SIZE_MAX_DEC=`echo ${FLASH_ROOT_SIZE} | awk --non-decimal-data '{printf "%d\n", $1}' `
	KERNEL_SIZE=`ls -l $KERNEL | awk '{print $5}'`
	if [ $KERNEL_SIZE -gt $KERNEL_SIZE_MAX_DEC ]; then
		oefatal "Kernel too large at $KERNEL_SIZE bytes.  Max is $KERNEL_SIZE_MAX_DEC."
		exit 1
	fi
	ROOT_SIZE=`ls -l $ROOTFS | awk '{print $5}'`
	if [ $ROOT_SIZE -gt $ROOT_SIZE_MAX_DEC ]; then
		oefatal "Rootfs is too large at $ROOT_SIZE bytes.  Max is $ROOT_SIZE_MAX_DEC."
		exit 1
	fi
	PAD_SIZE=`echo "$KERNEL_SIZE_MAX_DEC - $KERNEL_SIZE" | bc `
	dd if=/dev/zero of=$PADFILE bs=$PAD_SIZE count=1 2>>/dev/null
	cat $KERNEL $PADFILE $ROOTFS > $OUTPUT
	rm -f $PADFILE
	ls -l $OUTPUT
}

IMAGE_POSTPROCESS_COMMAND += "concat_pack_image; "

