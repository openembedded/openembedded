require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"

ALLOW_EMPTY = "1"

XORG_PN = "xtrans"

SRC_URI += "file://fix-missing-includepath.patch;patch=1"

SRC_URI[archive.md5sum] = "8b36cdf08df12be96615e3d550236626"
SRC_URI[archive.sha256sum] = "765219fa822edeffb0650e93458e4ebf63c23176e58fce06806fb251fbfe7d8c"
