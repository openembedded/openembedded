export IMAGE_BASENAME = "xfce-image"

IMAGE_LINGUAS = ""

X_DEPENDS = "virtual/xserver"
X_RDEPENDS = "xserver-kdrive-fbdev"

XFCE_DEPENDS = "task-bootstrap task-xfce-base"
XFCE_RDEPENDS = "${XFCE_DEPENDS}"

export IPKG_INSTALL = "${X_RDEPENDS} ${XFCE_RDEPENDS}"
DEPENDS = "${X_DEPENDS} ${XFCE_DEPENDS}"

inherit image_ipk
LICENSE = MIT
