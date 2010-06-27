require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a5e1f2539b82206e411c3647f10c425f"
SRC_URI[archive.sha256sum] = "91ed99ae936be5df25d310d81e31e0a7efefc023e462d93a9289ac18ebdf4e89"
