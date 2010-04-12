require xorg-lib-common.inc

DESCRIPTION = "Xprint job utility client library"
DEPENDS += "libxp libxt libxprintutil"
PR = "r1"
PE = "1"

XORG_PN = "libXprintAppUtil"

SRC_URI[archive.md5sum] = "d2de510570aa6714681109b2ba178365"
SRC_URI[archive.sha256sum] = "24606446003379dbf499ef57e9294ce622c0f7f8a8f10834db61dc59ef690aa5"
