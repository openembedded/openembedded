require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "3c97c7925ebf4162eeb3463e23adc0e3"
SRC_URI[archive.sha256sum] = "3863851e3c85d25cc38941eec63e866656806821b028519ae32ab8b276664fba"
