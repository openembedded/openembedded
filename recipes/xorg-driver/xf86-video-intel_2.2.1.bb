require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "3334dc5142871b78fc609fd1b3dac3f2"
SRC_URI[archive.sha256sum] = "d976c5f5e9c84f3817aba6ad22855446f1c2b9bfa0d53bd11c37c62cfdefa60a"
