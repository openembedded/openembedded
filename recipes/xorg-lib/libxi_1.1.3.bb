require xorg-lib-common.inc

DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PR = "r1"
PE = "1"

XORG_PN = "libXi"

SRC_URI[archive.md5sum] = "7c510abb0cad8dc20493fb27ff7859d8"
SRC_URI[archive.sha256sum] = "c77a5bbe97d0d0a6493adefcf1bd57aca91bc33279633b3f6cf1d2bb8812153f"
