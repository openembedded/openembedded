DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager"

DEPENDS = "${MACHINE_TASK_PROVIDER} \
           ${XSERVER} \
           task-e-x11-core"

IMAGE_INSTALL = "${MACHINE_TASK_PROVIDER} task-e-x11-core ${XSERVER} glibc-charmap-utf-8 glibc-localedata-i18n"
IMAGE_LINGUAS = ""

inherit image
