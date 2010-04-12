require xorg-lib-common.inc

DESCRIPTION = "X11 Rendering Extension client library"
LICENSE = "BSD-X"
DEPENDS += "virtual/libx11 renderproto xproto"
PR = "r1"
PE = "1"

XORG_PN = "libXrender"

SRC_URI[archive.md5sum] = "2f1b2c6e8dcbcb6d760e59f445abd92c"
SRC_URI[archive.sha256sum] = "0f749183ab1a0ece14d33c3299b3f70893122349c0bfa9d7bd0e66ce19d1802a"
