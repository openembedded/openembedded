require xorg-app-common.inc
DESCRIPTION = "create an X cursor file from a collection of PNG images"
DEPENDS += " libxcursor libpng"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "731c39ea88217c12ddd37f8627d97f3f"
SRC_URI[archive.sha256sum] = "de2adb2f44ffee906024e53322aeb728d46061e6ca8e6f5a7e0da2c00d6f5f1d"

BBCLASSEXTEND = "native"
