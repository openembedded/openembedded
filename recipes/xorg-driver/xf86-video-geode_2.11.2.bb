require xorg-driver-video.inc
PE = "1"

COMPATIBLE_HOST = 'i.86.*-linux'
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"

SRC_URI += "file://0001-probe-GPIO-device-before-asking-for-base_addr.patch;patch=1 \
            file://0002-GX-fix-RandR-to-properly-use-dixSetPrivate.patch;patch=1 \
           "
