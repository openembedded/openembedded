require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
BBCLASSEXTEND = "native sdk"
FILESPATHPKG .= ":xtrans-${PV}:xtrans"
PE = "1"

ALLOW_EMPTY = "1"

SRC_URI += "file://fix-missing-includepath.patch"

SRC_URI[archive.md5sum] = "8b36cdf08df12be96615e3d550236626"
SRC_URI[archive.sha256sum] = "765219fa822edeffb0650e93458e4ebf63c23176e58fce06806fb251fbfe7d8c"
