require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "9a2aad51042141a0e6ad066015397595"
SRC_URI[archive.sha256sum] = "95d55283f32d241c8e6750b7998408da43e910d2b918c80089a3012684f1c62d"
