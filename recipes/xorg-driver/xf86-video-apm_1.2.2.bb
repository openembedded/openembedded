require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "This is the Alliance Promotion driver for XFree86 4.0+"

DEPENDS += " xf86rushproto"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
