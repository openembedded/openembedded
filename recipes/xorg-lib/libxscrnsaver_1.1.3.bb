require xorg-lib-common.inc

DESCRIPTION = "X Screen Saver extension library"
LICENSE = "GPL"
DEPENDS += "libxext scrnsaverproto"
PROVIDES = "libxss"
RREPLACES = "libxss"
PR = "r1"
PE = "1"

XORG_PN = "libXScrnSaver"

SRC_URI[archive.md5sum] = "93f84b6797f2f29cae1ce23b0355d00d"
SRC_URI[archive.sha256sum] = "4b90245093c15a24aaaf2fc6e09f075137aad994f72043e098597997d9b2c988"
