require gpe-image.bb


PR = "r5"

export IMAGE_BASENAME = "gpe-image-blank-user"

ROOTFS_POSTPROCESS_COMMAND += "adduser -D user"
