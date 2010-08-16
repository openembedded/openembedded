require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7b2642442091808002963920c7693aeb"
SRC_URI[archive.sha256sum] = "6d07847d63798f92237175f2645bf964d083b18c4c439e6c787a5f0c3dd68e31"
