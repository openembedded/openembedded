require xorg-app-common.inc

DESCRIPTION = "X Resize and Rotate extension command."
LICENSE= "BSD-X"
DEPENDS += "libxrandr libxrender"
PE = "1"

SRC_URI += "file://resolve_symbol_clash.patch;patch=1"

SRC_URI[archive.md5sum] = "c6ec9dc42396e3b3a2da932f3feca6ec"
SRC_URI[archive.sha256sum] = "632f3ff492a07f8279807ffbafe4f89af069bb0e7b4934b3ddf7379509aa9303"
