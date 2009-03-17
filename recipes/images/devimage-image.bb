# Image for kernel debugging and development testing
# It includes all useful "kernel userspace" utilities, but
# only shell and dropbear are loaded by default.
# Allows to login via serial and real console or SSH

DEPENDS = "task-devimage"
IMAGE_INSTALL = "task-devimage"

export IMAGE_BASENAME = "devimage"
IMAGE_LINGUAS = ""

inherit image
