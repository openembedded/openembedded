require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "e662348f6f957fcedf52818d668ab9f5"
SRC_URI[archive.sha256sum] = "cfde066a7087a19b624f79e95cb9a6c97a847b8802cf38d4ae6022758bf338f6"
