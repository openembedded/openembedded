require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "0ebf98f1beaf911a242c79647cc08fbf"
SRC_URI[archive.sha256sum] = "3aa66d6dcc44302a91c7c829e15cd7b09176164476f5cb65dda190e1862ed71a"
