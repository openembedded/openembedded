require xorg-app-common.inc

DESCRIPTION = "X Event Viewer"
LICENSE = "MIT"
PE = "1"

SRC_URI += "file://diet-x11.patch;patch=1"

SRC_URI[archive.md5sum] = "e3008eb0655da3026c162a5597d70869"
SRC_URI[archive.sha256sum] = "cac2771b67942d9a00b46532176feb18b2f82c434e0f6ece578d95953ef33053"
