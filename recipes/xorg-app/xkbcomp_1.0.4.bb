require xorg-app-common.inc

DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

DEPENDS += " virtual/libx11 libxkbfile"

SRC_URI[archive.md5sum] = "d5122f1d5a91725a81c843f3bd388244"
SRC_URI[archive.sha256sum] = "fefc574bf639d64348939edf9654306af2bb3c20447be9cff493cb06d87cb672"
