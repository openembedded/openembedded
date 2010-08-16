require xorg-driver-video.inc
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1dbede8f6393edfe6c1ecab2f754b3b2"
SRC_URI[archive.sha256sum] = "d70c198cde981c3a53b1c41b717dea4bbf1d397d82957f584c641bb5fd02c82d"

COMPATIBLE_HOST = "i.86.*-linux"
