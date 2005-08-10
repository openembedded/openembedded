export IMAGE_BASENAME = "e-image"

DEPENDS = "task-bootstrap meta-e-x11"

export IPKG_INSTALL = "task-bootstrap e-base"

inherit image_ipk
LICENSE = MIT
