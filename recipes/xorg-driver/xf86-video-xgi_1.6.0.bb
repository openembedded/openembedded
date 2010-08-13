require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "b4ac771ae81b52fca9b6fa68006a258a"
SRC_URI[archive.sha256sum] = "e83406eb5c2b0d5eae208164544883a31af7842710fafb27d765c61b8a4a9417"
