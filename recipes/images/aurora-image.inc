###############################################################################
# Aurora Base Image
###############################################################################

PV = "0.1"

IMAGE_DEBUG_APPEND = '${@base_conditional("DISTRO_TYPE", "debug", "gdb strace mdbus2", "",d)}'

IMAGE_INSTALL = " \
    task-base \
    glibc-utils \
    glibc-charmap-utf-8 \
    initscripts \
    netbase \
    sysfsutils \
    modutils-initscripts \
    module-init-tools-depmod \
    ttf-ubuntu-sans \
    task-fso2-compliance \
    iptables \
    alsa-utils-aplay \
    alsa-utils-alsamixer \
    aurora \
    ${IMAGE_DEBUG_APPEND} \
"
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"
export IMAGE_BASENAME = "aurora-image"

inherit image

