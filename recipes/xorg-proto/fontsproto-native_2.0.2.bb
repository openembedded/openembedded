require fontsproto_${PV}.bb
require xorg-proto-native.inc

PR = "r1"

XORG_PN = "fontsproto"

S = "${WORKDIR}/fontsproto-${PV}"

SRC_URI[archive.md5sum] = "c946f166107b016a21cc7a02e1132724"
SRC_URI[archive.sha256sum] = "83bd547131aa11a232717a0f06d3c6cd58a0b2f6d541660bbe9ebf43073a8b7b"
