require xorg-lib-common.inc
DESCRIPTION = "X11 Video extension library"
LICENSE = "GPL"
DEPENDS += "libxext videoproto"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "f1c4109fa804aeaf7188b66c5cdd9f57"
SRC_URI[archive.sha256sum] = "f87ae65be39a3c26dc3c87159d9126daf2af1b8c5e7f2ffc38b9f72b9236261b"

XORG_PN = "libXv"
