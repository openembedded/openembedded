require xorg-lib-common.inc
DESCRIPTION = "X11 Resource extension library"
DEPENDS += "libxext resourceproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "d08f0b6df3f96c051637d37009f4e55a"
SRC_URI[archive.sha256sum] = "a00b0f464bc0c038db5614513b0e33475db22a7b3cd41e4e56a6c661a518a059"

XORG_PN = "libXres"
