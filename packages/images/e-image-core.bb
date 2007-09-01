DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager"

DEPENDS = "${MACHINE_TASK_PROVIDER} \
           xserver-kdrive \
           task-e-x11-core"

IMAGE_INSTALL = "${MACHINE_TASK_PROVIDER} task-e-x11-core xserver-kdrive-fbdev glibc-charmap-utf-8 glibc-localedata-i18n"
IMAGE_LINGUAS = ""

inherit image
