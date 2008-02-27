require xorg-app-common.inc
PE = "1"

DESCRIPTION = "Applications that would like to take advantage of the Low Bandwidth \
extension to X (LBX) must make their connections to an lbxproxy."

DEPENDS += " xtrans libxext liblbxutil virtual/libx11 libice xproxymngproto bigreqsproto zlib"
