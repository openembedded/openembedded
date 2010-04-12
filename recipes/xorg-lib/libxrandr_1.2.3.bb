require xorg-lib-common.inc

DESCRIPTION = "X11 Resize and Rotate extension library"
LICENSE = "BSD-X"
DEPENDS += "randrproto libxrender libxext"
PR = "r0"
PE = "1"

XORG_PN = "libXrandr"

SRC_URI[archive.md5sum] = "5cd67cc02a50c9644ba0a1846ea3b08e"
SRC_URI[archive.sha256sum] = "f8edfe26b8c4c3677a3a949f81a8b09a5fad62972020bfd230401e11cc0ed267"
