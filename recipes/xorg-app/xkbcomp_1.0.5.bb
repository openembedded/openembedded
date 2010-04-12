require xorg-app-common.inc

DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

DEPENDS += " virtual/libx11 libxkbfile"

SRC_URI[archive.md5sum] = "6cc96c3e4ed5d9802fe717beac008f19"
SRC_URI[archive.sha256sum] = "204403e0388e83127212109310037d17f56c3c3fd3c96d7dcaa0df99684f00c1"
