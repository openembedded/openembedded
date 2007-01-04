export IMAGE_BASENAME = "bootstrap-image-bootchart"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${MACHINE_TASK_PROVIDER} bootchart acct"

DEPENDS = "${MACHINE_TASK_PROVIDER} bootchart"
RDEPENDS = "acct"

inherit image

LICENSE = "MIT"
