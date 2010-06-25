require xorg-lib-common.inc
DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4b88e07d7dd77ca1e786f09066b58c02"
SRC_URI[archive.sha256sum] = "7c0125ffb864e121ebfb5a20b1cfdff60562c2f2dfbb4e77c5eac81f36e15f3a"

XORG_PN = "libXi"
