require xorg-driver-video.inc
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "579ef0bc08e1267db025c3dcb9e588f3"
SRC_URI[archive.sha256sum] = "eb89afe34ea48c7fed0a911be2c05861e415ba1fd9c4390d568a324307572a82"

COMPATIBLE_HOST = "i.86.*-linux"
