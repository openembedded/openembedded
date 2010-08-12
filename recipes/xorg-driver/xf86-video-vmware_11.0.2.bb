require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "00c3a70870abcda5f340497b0285dab1"
SRC_URI[archive.sha256sum] = "eab19da564b9488423424722fc84309fba2c10f1b90c092bf993f80c59f475d2"
