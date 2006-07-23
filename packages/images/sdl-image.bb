LICENSE = MIT

export IMAGE_BASENAME = "sdl-image"

DEPENDS = "task-bootstrap task-sdl"

export IPKG_INSTALL = "task-bootstrap sdl-base"

inherit image_ipk
