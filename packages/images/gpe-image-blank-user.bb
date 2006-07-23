include gpe-image.bb

MAINTAINER = "Rob Taylor <rjt@cambridgebroadband.com"

PR = "r5"

export IMAGE_BASENAME = "gpe-image-blank-user"

ROOTFS_POSTPROCESS_COMMAND += "adduser -D user"
