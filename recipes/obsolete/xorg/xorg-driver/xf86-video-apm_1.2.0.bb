require xorg-driver-video.inc
DESCRIPTION = "This is the Alliance Promotion driver for XFree86 4.0+"
DEPENDS += " xf86rushproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://get-rid-of-host-includes.patch"
SRC_URI[archive.md5sum] = "4f78650d79656dc803a720049d65682e"
SRC_URI[archive.sha256sum] = "f0fe020f892e6e3a696a490c86312a1b32672bffb7dead153c24f103540a6185"
