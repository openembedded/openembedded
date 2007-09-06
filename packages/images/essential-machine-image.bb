#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see COPYING.MIT)
#
# Filename: essential-machine-image.bb
# Date: 24-Apr-06

DESCRIPTION = "<description>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

DEPENDS = "task-essential-to-boot task-essential-parts"

MACHINE_TASKS_akita = "task-essential-to-boot \
		       task-essential-pcmcia task-essential-userspace \
		       task-essential-usbhost task-essential-usbclient \
		       task-essential-sound task-essential-irda \
		       task-essential-sd"

IMAGE_LINGUAS = ""
IMAGE_INSTALL = "${MACHINE_TASKS}"
export IMAGE_BASENAME = "essential-image"

inherit image