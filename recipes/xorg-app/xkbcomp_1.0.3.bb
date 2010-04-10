require xorg-app-common.inc

DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

DEPENDS += " virtual/libx11 libxkbfile"

SRC_URI[archive.md5sum] = "2fbcae1323c266edf5b6c61751f2e343"
SRC_URI[archive.sha256sum] = "0635bae5dae3c933ebba997475ae14fa213aee1f2ea8aaff2ca76c50f8aec716"
