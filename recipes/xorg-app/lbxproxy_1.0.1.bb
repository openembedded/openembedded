require xorg-app-common.inc
PE = "1"

DESCRIPTION = "Applications that would like to take advantage of the Low Bandwidth \
extension to X (LBX) must make their connections to an lbxproxy."

DEPENDS += " xtrans libxext liblbxutil virtual/libx11 libice xproxymngproto bigreqsproto zlib"

SRC_URI[archive.md5sum] = "9d5045a5c76b1fe360221b967a5aa0e9"
SRC_URI[archive.sha256sum] = "e2e757986724a5d2ee299aa7616a3d9985af45e363021b486b7abbcac4ca01c2"
