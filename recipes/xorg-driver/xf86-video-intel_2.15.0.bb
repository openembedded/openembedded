require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS_${PN} += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
             xserver-xorg-extension-glx"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ba56ae395a9769ada1fef2014468bee9"
SRC_URI[archive.sha256sum] = "c377e1e9ab8b846d7e039acc9105479d5dce6a03f1ddccccf01c8474259c1720"
