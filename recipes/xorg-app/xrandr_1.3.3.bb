require xorg-app-common.inc
DESCRIPTION = "X Resize and Rotate extension command."
LICENSE = "BSD-X"
DEPENDS += "libxrandr libxrender"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "5b2dcfb0d9b736afaf78f6ce7651259c"
SRC_URI[archive.sha256sum] = "968ff3e6d33bdbdc83876e35f3ff463f6607362716d276d799a6c40dc2e43e46"
