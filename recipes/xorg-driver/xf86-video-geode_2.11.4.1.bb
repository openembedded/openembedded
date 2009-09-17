require xorg-driver-video.inc
PE = "1"
PR = "r1"

COMPATIBLE_HOST = 'i.86.*-linux'
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"

SRC_URI += "file://fixes.patch;patch=1"
