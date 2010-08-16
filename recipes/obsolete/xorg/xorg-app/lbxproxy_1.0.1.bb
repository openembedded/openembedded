require xorg-app-common.inc
DESCRIPTION = "Applications that would like to take advantage of the Low Bandwidth \
extension to X (LBX) must make their connections to an lbxproxy."
DEPENDS += " xtrans libxext liblbxutil libice xproxymngproto bigreqsproto zlib"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "9d5045a5c76b1fe360221b967a5aa0e9"
SRC_URI[archive.sha256sum] = "e2e757986724a5d2ee299aa7616a3d9985af45e363021b486b7abbcac4ca01c2"
