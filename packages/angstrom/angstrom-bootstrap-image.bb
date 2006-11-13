#Angstrom bootstrap image
LICENSE = "MIT"
PR = "r2"

DEPENDS = "task-base"
RDEPENDS = "task-base-core-default task-base"

export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "${RDEPENDS}"

inherit image_ipk

