require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS_${PN} += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
             xserver-xorg-extension-glx"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7c48151a87311beea39837812e7b9e2b"
SRC_URI[archive.sha256sum] = "da9ab33ad03c2a51d1c78d648d481f251b5fd3c13f0644a58a7f097b08d6a27f"
