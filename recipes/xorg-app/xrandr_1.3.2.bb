require xorg-app-common.inc

DESCRIPTION = "X Resize and Rotate extension command."
LICENSE= "BSD-X"
DEPENDS += "libxrandr libxrender"
PE = "1"

SRC_URI += "file://resolve_symbol_clash.patch;patch=1"

SRC_URI[archive.md5sum] = "2cb19bb1c19ccf77c40032b03dbe06f0"
SRC_URI[archive.sha256sum] = "34d4334644a6494573141bb8647feb8f91c0ce8c8d3b6883b4861e038e912249"
