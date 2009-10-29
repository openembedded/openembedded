require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- ark display driver"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
