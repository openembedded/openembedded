###############################################################################
# Aurora Base Image
###############################################################################

PV = "0.1"

IMAGE_DEBUG_APPEND = '${@base_conditional("DISTRO_TYPE", "debug", "gdb strace mdbus2", "",d)}'

IMAGE_INSTALL = " \
    task-base \
    task-cli-tools \
    task-cli-tools-python \
    task-fso2-compliance \
    \
    ttf-ubuntu-sans \
    aurora \
    \
    ${IMAGE_DEBUG_APPEND} \
"
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"
export IMAGE_BASENAME = "aurora-image"

inherit image

