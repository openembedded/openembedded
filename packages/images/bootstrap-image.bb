export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${MACHINE_TASK_PROVIDER}"

DEPENDS = "${MACHINE_TASK_PROVIDER}"

inherit image

LICENSE = "MIT"
