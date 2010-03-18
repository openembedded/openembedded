require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "6c0522b2b72a0a47c48d718443616651"
SRC_URI[archive.sha256sum] = "b91194033023a41793a525a631789df1d229b228af0d44dcbe20b06ed66c671d"
