require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto "
RDEPENDS_${PN} += "xserver-xorg-extension-dri \
             xserver-xorg-extension-dri2 \
             xserver-xorg-extension-glx"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "8314def847dcdc4f2970e2d193054f96"
SRC_URI[archive.sha256sum] = "e16b7fb91f72af825bd26693d5329e3a8f42801a0c31858836b59408f8fdffdf"
