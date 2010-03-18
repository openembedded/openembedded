require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += " xineramaproto xf86miscproto xf86dgaproto drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "43f12cabf770b06170cdd1cdaafdc50f"
SRC_URI[archive.sha256sum] = "50856446841526fc393af6bae0fbc39c20bb07e60056a676d0bc620446b593ac"
