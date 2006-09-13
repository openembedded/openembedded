LICENSE = MIT

export IMAGE_BASENAME = "sdl-image"

DEPENDS = "${MACHINE_TASK_PROVIDER} task-sdl"

export IPKG_INSTALL = "${MACHINE_TASK_PROVIDER} sdl-base"

inherit image_ipk
