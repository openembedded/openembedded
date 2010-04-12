require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"

ALLOW_EMPTY = "1"

SRC_URI += "file://fix-missing-includepath.patch;patch=1"

SRC_URI[archive.md5sum] = "a91fef8b932b21992af7dfff7b2643f3"
SRC_URI[archive.sha256sum] = "d6c3cabd5ecd0183a8a9bc6b3471545df8e2c78956b4c4cfd48f0c545a88c9a4"
