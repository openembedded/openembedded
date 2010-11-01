require xorg-lib-common.inc
DESCRIPTION = "X11 EvIE extension library"
DEPENDS += "libxext evieext"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ffa3f82595211609140440505b0e6301"
SRC_URI[archive.sha256sum] = "c00b382123e58f595b3cecaa50471ebec534660e5f92ae46d94266345844fd73"

XORG_PN = "libXevie"
