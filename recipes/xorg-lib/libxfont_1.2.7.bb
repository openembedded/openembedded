require xorg-lib-common.inc

DESCRIPTION = "X font library (used by the X server)."
LICENSE= "BSD-X"
PRIORITY = "optional"

SRC_URI += "file://no-scalable-crash.patch"

DEPENDS += " freetype fontcacheproto zlib xproto xtrans fontsproto libfontenc"
BBCLASSEXTEND = "native"
PE = "1"

XORG_PN = "libXfont"


SRC_URI[archive.md5sum] = "2f2085310f75900044d9dcd469637d26"
SRC_URI[archive.sha256sum] = "2f8c004c0b914d460e6fd2b48d8b425cf4778d415467fc1f1d938b200462d18b"
