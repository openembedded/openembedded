require xorg-lib-common.inc
DESCRIPTION = "X11 Xinerama extension library"
DEPENDS += "libxext xineramaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ecd4839ad01f6f637c6fb5327207f89b"
SRC_URI[archive.sha256sum] = "bbe2b4a0e8ccf01a40f02c429c8418bd1fe652fd2c6f05d487e1319599d6779f"

XORG_PN = "libXinerama"
