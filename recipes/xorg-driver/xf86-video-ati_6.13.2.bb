require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a8f92fe3c458e511f4e2ead7f92c02b0"
SRC_URI[archive.sha256sum] = "d85f60081e5b71bf19da4ca48bce95a9e9df3635c8540dd2640785bedfbc36ee"
