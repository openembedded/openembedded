require xorg-app-common.inc

DESCRIPTION = "X Resize and Rotate extension command."
LICENSE= "BSD-X"
DEPENDS += "libxrandr libxrender"
PE = "1"

SRC_URI += "file://resolve_symbol_clash.patch;patch=1"

SRC_URI[archive.md5sum] = "41a9d0cc073fa6165a31fbf9e85f68a6"
SRC_URI[archive.sha256sum] = "ab06b77f3a2b8866279e096f9d2702ac644681424eb0aec39e4eb7199f152207"
