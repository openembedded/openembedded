require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
SRC_URI[archive.md5sum] = "6081b8fa50c689d51f85c2fbaf93867e"
SRC_URI[archive.sha256sum] = "fba616f88d351759e00a90965e38a0d82608698ae36fc2a18df4036cd384e1a1"
