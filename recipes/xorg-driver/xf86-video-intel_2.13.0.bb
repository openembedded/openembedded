require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS_${PN} += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
             xserver-xorg-extension-glx"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "de2f8a5836d90c71f3175dcd46d03ec0"
SRC_URI[archive.sha256sum] = "d8b2fae8d0c4ae372994cb7df8de8aa995b8e89b1bc5766c53ea0751752fc887"
