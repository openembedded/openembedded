require xorg-lib-common.inc
DESCRIPTION = "X11 Xinerama extension library"
DEPENDS += "libxext xineramaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a2ac01fc0426cdbb713c5d59cf9955ed"
SRC_URI[archive.sha256sum] = "e0d39e74c2e131b44cc98dd4910165c9b8d937df93be58e6afb7c2a56772bf34"

XORG_PN = "libXinerama"
