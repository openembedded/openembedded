require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Glint display driver"
DEPENDS += " xf86dgaproto drm xf86driproto"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "77313a32280bdfee6269e28eca144274"
SRC_URI[archive.sha256sum] = "5675f2732ab7b099a568ef4e5c7bb0d0e1bb4b0eb4d19133dc1b2225fd9c814b"
