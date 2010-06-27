require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "52e9a12843c6469f976db57a7b5f78d2"
SRC_URI[archive.sha256sum] = "a6371d5acb81ba4457f7ee2c7432941c38f9033ce5278551c6acc9a0827ce7be"
