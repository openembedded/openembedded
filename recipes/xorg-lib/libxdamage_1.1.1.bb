require xorg-lib-common.inc
DESCRIPTION = "X11 damaged region extension library"
LICENSE = "BSD-X"
DEPENDS += "damageproto libxfixes"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ac0ce6b0063a9858c8f24ddb4c60487d"
SRC_URI[archive.sha256sum] = "0102754db23952a1c3adf7881bbf191f91ca3e3d183e1b0179452bce932fae2e"

XORG_PN = "libXdamage"
