require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "440c014bbd3072b5d379fe1bdb861918"
SRC_URI[archive.sha256sum] = "b35a142aeba034ad06b8d9b477c243f82ce9f82ad65a0ee4408630f228e90258"
