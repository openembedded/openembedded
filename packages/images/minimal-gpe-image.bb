#Angstrom minimal gpe image
# This image provides a barebone dm and 'desktop' 
# Very angstrom and ipkg centric

XSERVER ?= "xserver-kdrive-fbdev"

export IMAGE_BASENAME = "minimalist-gpe-image"

DEPENDS = "task-boot"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-boot \
    gpe-session-scripts gpe-login \
    matchbox-wm \
    angstrom-feed-configs \
    ipkg \
    "

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
