require xorg-app-common.inc
DESCRIPTION = "X Resize and Rotate extension command."
LICENSE = "BSD-X"
DEPENDS += "libxrandr libxrender"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "d6d20038257eba5178b523e10239d51c"
SRC_URI[archive.sha256sum] = "5e4a2492e6cc51345aa571b95283c43c2771c4f444837dbce2699d62f76b4adb"
