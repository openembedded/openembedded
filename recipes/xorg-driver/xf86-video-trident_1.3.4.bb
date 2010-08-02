require xorg-driver-video.inc
DESCRIPTION = "X.org X server -- Trident display driver"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7a646ba7033dd4eb10d38dca8682b391"
SRC_URI[archive.sha256sum] = "58e61631e0ef2c58c3c81afb7d7b8d2b46504bdc3dd84fd1ab2798c6f1f29ca8"
