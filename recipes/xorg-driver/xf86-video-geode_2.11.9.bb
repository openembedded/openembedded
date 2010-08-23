require xorg-driver-video.inc
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "718afca8425aa62662c03a9083915be1"
SRC_URI[archive.sha256sum] = "b30d14a8ad389be055f95133a14e2da8ad43892b3fb5225d99bfb571cfec7bb5"

COMPATIBLE_HOST = "i.86.*-linux"
