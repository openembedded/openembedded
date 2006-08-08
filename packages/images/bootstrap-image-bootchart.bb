export IMAGE_BASENAME = "bootstrap-image-bootchart"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-bootstrap bootchart acct"

DEPENDS = "task-bootstrap bootchart"
RDEPENDS = "acct"

inherit image_ipk

LICENSE = MIT
