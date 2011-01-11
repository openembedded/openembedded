require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "25287a202c986b33bd79fbe379c96a16"
SRC_URI[archive.sha256sum] = "956443948d94f7459b0056d8cb8ff2cd9fba4621d8b61f0257cb84469ea7da07"
