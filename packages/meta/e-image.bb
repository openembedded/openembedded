export IMAGE_BASENAME = "e-image"

DEPENDS = "task-bootstrap meta-e"

export IPKG_INSTALL = "task-bootstrap e-base"

inherit image_ipk
LICENSE = MIT
