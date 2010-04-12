require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"

ALLOW_EMPTY = "1"

SRC_URI += "file://fix-missing-includepath.patch;patch=1"

SRC_URI[archive.md5sum] = "bb196907ea1e182dcb396eb22f7d2c1a"
SRC_URI[archive.sha256sum] = "e1a3c4986f16a5fbca611d0547cc7499a1fa47ca2096593644037e2609363085"
