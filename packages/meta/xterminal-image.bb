export IMAGE_BASENAME = "xterminal-image"

IMAGE_LINGUAS = ""

XTERMINAL_PACKAGES = "task-bootstrap task-xterminal"

export IPKG_INSTALL = "${XTERMINAL_PACKAGES}"
DEPENDS = "${XTERMINAL_PACKAGES}"

inherit image_ipk
LICENSE = MIT
