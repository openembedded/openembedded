export IMAGE_BASENAME = "sdl-image"

DEPENDS = "task-bootstrap meta-sdl"

export IPKG_INSTALL = "task-bootstrap sdl-base"

inherit image_ipk
LICENSE = MIT
