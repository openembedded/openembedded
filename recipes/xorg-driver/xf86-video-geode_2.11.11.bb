require xorg-driver-video.inc
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ea36cc51588a1ba73442237db2bf560b"
SRC_URI[archive.sha256sum] = "861727b1f183060a2d0d89997e0fb3e1564c5d4c2e7b453ab2999f3d6c15400c"

COMPATIBLE_HOST = "i.86.*-linux"
