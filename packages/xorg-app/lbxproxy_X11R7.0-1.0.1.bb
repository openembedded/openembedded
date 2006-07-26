include xorg-app-common.inc

DESCRIPTION = "Applications that would like to take advantage of the Low Bandwidth \
extension to X (LBX) must make their connections to an lbxproxy."

DEPENDS += " xtrans libxext liblbxutil virtual/x11 libice xproxymngproto bigreqsproto zlib"
