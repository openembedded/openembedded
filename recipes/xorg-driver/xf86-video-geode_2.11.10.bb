require xorg-driver-video.inc
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "8161cd380673c44177245d1d84366219"
SRC_URI[archive.sha256sum] = "8e45c4849a2405cecff7a24c990c2b0a88621aeb103d1937c5ac05d78a1fabfd"

COMPATIBLE_HOST = "i.86.*-linux"
