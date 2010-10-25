require xorg-lib-common.inc
DESCRIPTION = "X11 font encoding library"
LICENSE = "BSD-X"
DEPENDS += "zlib xproto font-util-native"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "11d3c292f05a90f6f67840a9e9c3d9b8"
SRC_URI[archive.sha256sum] = "348a1b0142f61afeaafc9497e997d6f10074affed8682e202d019f10170b9cbf"

BBCLASSEXTEND = "native"
