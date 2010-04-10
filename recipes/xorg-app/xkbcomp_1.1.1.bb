require xorg-app-common.inc

DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

DEPENDS += " virtual/libx11 libxkbfile"

SRC_URI[archive.md5sum] = "38c387bacdc01038c8ac280588792bcf"
SRC_URI[archive.sha256sum] = "9775bcfd43d9ffa41e2865e5b2c933f419bf983d7a529b3103656c76fd82e663"
