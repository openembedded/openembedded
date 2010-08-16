require xorg-lib-common.inc
DESCRIPTION = "X font library (used by the X server)."
PRIORITY = "optional"
LICENSE = "BSD-X"
DEPENDS += " freetype fontcacheproto zlib xproto xtrans fontsproto libfontenc"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://no-scalable-crash.patch"
SRC_URI[archive.md5sum] = "2f2085310f75900044d9dcd469637d26"
SRC_URI[archive.sha256sum] = "2f8c004c0b914d460e6fd2b48d8b425cf4778d415467fc1f1d938b200462d18b"

BBCLASSEXTEND = "native"

XORG_PN = "libXfont"
