# KaeilOS X11 image
# plus JVM and OTHER

ANGSTROM_EXTRA_INSTALL ?= ""
XSERVER ?= "xserver-kdrive-fbdev"

export IMAGE_BASENAME = "x11-jvm-image"

DEPENDS = "task-base"

ADD_JVM = "\
    classpath \
    classpath-common \
    classpath-dev \
    classpath-examples \
    classpath-gconf \
    classpath-gtk \
    classpath-tools \
    jamvm \
    cacao "

IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    ${SPLASH} \
    ${ADD_JVM} \
    ${ADD_OTHER} \
    ${ANGSTROM_EXTRA_INSTALL}"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
