export IMAGE_BASENAME = "xfce-image"

IMAGE_LINGUAS = ""

XSERVER ?= "xserver-kdrive-fbdev"

X_DEPENDS = "virtual/xserver"
X_RDEPENDS = "${XSERVER}"

XFCE_DEPENDS = "${MACHINE_TASK_PROVIDER} task-xfce-base"
XFCE_RDEPENDS = "${XFCE_DEPENDS}"

export PACKAGE_INSTALL = "${X_RDEPENDS} ${XFCE_RDEPENDS}"
DEPENDS = "${X_DEPENDS} ${XFCE_DEPENDS}"

inherit image
LICENSE = "MIT"
