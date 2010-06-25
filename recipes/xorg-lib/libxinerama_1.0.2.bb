require xorg-lib-common.inc
DESCRIPTION = "X11 Xinerama extension library"
DEPENDS += "libxext xineramaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "f6fb08eafd3c2909d515f1a07bfca8fd"
SRC_URI[archive.sha256sum] = "d245d7ae4c766ecbc4e5cc2666e2e78198d8386dbaa06b35c3d1b1457ee5d03d"

XORG_PN = "libXinerama"
