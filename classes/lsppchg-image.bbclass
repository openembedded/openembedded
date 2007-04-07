IMAGE_PREPROCESS_COMMAND_lsppchg += "export KPATH=`ls -tr ${IMAGE_ROOTFS}/boot/uImage-* | tail -1`; ln -sf /boot/${KPATH##*/} ${IMAGE_ROOTFS}/boot/uImage;"
IMAGE_PREPROCESS_COMMAND_lsppchg += "sed -i -es,^id:5:initdefault:,id:3:initdefault:, ${IMAGE_ROOTFS}/etc/inittab;"
IMAGE_PREPROCESS_COMMAND_lsppchg += "sed -i -es,^root::0,root:BTMzOOAQfESg6:0, ${IMAGE_ROOTFS}/etc/passwd;"
IMAGE_PREPROCESS_COMMAND_lsppchg += "sed -i -es,^VERBOSE=no,VERBOSE=very, ${IMAGE_ROOTFS}/etc/default/rcS;"

lsppchg_pack_image() {
:
}

IMAGE_POSTPROCESS_COMMAND += "lsppchg_pack_image; "
