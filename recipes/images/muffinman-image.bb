export IMAGE_BASENAME = "muffinman-image"

IMAGE_LINGUAS = ""

XSERVER ?= "xserver-xorg \
            xf86-input-evdev \
            xf86-video-fbdev"

X_DEPENDS = "virtual/xserver"
X_RDEPENDS = "${XSERVER}"

MUFFINMAN_DEPENDS = "${MACHINE_TASK_PROVIDER} task-muffinman"
MUFFINMAN_RDEPENDS = "${MUFFINMAN_DEPENDS}"

IMAGE_INSTALL = "${X_RDEPENDS} ${MUFFINMAN_RDEPENDS}"
DEPENDS = "${X_DEPENDS} ${MUFFINMAN_DEPENDS}"

inherit image
