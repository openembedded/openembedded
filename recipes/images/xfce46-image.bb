PR = "r1"

export IMAGE_BASENAME = "xfce46-image"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

DEPENDS = "virtual/xserver ${MACHINE_TASK_PROVIDER} task-xfce46-base task-xfce46-extras  \
"

IMAGE_INSTALL = "${XSERVER} ${MACHINE_TASK_PROVIDER} task-xfce46-base task-xfce46-extras \
"

inherit image
