require xorg-app-common.inc
DESCRIPTION = "Applications that would like to take advantage of the Low Bandwidth \
extension to X (LBX) must make their connections to an lbxproxy."
DEPENDS += " xtrans libxext liblbxutil libice xproxymanagementprotocol bigreqsproto zlib"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "0aa9284354552ce6700485a36d2803c3"
SRC_URI[archive.sha256sum] = "7ec5dee387bb6f3125392c0faca1c9712898b31e1410de9767e0d933b21cb679"
