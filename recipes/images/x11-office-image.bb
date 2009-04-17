#Angstrom X11 image, with apps and kernel modules included

ANGSTROM_EXTRA_INSTALL += " \
			  " 
XSERVER ?= "xserver-kdrive-fbdev"
SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-angstrom", "",d)}'

export IMAGE_BASENAME = "x11-office-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    kernel-modules \
    hal \
    abiword \
    gnumeric \
    cups \
    claws-mail claws-mail claws-plugin-mailmbox claws-plugin-rssyl \
    midori minimo \
    gphoto2 \
    ${SPLASH} \
    ${ANGSTROM_EXTRA_INSTALL}"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
