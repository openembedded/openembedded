require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"

SRC_URI += " file://nodolt.patch;patch=1 "
SRC_URI[archive.md5sum] = "8951d0366c16991badb7f9050556f4f3"
SRC_URI[archive.sha256sum] = "95347c88854c2b41c07ab3bcdfadd1b8d27fb181a20520f185892877eb8d9d76"
