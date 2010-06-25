require xorg-lib-common.inc
DESCRIPTION = "X11 damaged region extension library"
LICENSE = "BSD-X"
DEPENDS += "damageproto libxfixes"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "b42780bce703ec202a33e5693991c09d"
SRC_URI[archive.sha256sum] = "a56a10acb34827c4d1a0ee282a338cbb04baa03d7fc7bc69e5690915c8fc7c0a"

XORG_PN = "libXdamage"
