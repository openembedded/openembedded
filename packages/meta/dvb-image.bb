export IMAGE_BASENAME = "dvb-image"

IMAGE_LINGUAS = ""

DVB_PACKAGES = "task-bootstrap task-dvb"

export IPKG_INSTALL = "${DVB_PACKAGES}"
DEPENDS = "${DVB_PACKAGES}"

inherit image_ipk
LICENSE = MIT
