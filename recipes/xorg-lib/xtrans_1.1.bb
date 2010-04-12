require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"

ALLOW_EMPTY = "1"

SRC_URI += "file://fix-missing-includepath.patch;patch=1"

SRC_URI[archive.md5sum] = "8546e3a060aefb42c889eaa4b5db33af"
SRC_URI[archive.sha256sum] = "16bc4646f105efd3d0dd105899ac19035d67acf50950ca8c70cf68772508272d"
