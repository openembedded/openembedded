require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "7bd53945ce6d0b48b7fd558039e82aa2"
SRC_URI[archive.sha256sum] = "b6c67996cfdbbf9b3a191b9092f5d515dd7fae564544626792dd5ef404e29134"
