require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "744a6ee1ebfe1c74e3b170b8d7ef8395"
SRC_URI[archive.sha256sum] = "ff8cd89c9ba39ce68dd6ac4dcb222280835d007a20b419819749298e8ec74259"
