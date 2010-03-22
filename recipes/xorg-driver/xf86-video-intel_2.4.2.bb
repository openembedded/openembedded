require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "5cd6b3ed57c7e78ab51e9d9266e73fb6"
SRC_URI[archive.sha256sum] = "5afdc91e93ffed09ea5258c6fde210c729ea2b44d83f98acfd92c3da7e99e64b"
