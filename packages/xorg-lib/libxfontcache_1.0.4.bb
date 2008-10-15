require xorg-lib-common.inc

DESCRIPTION = "X-TrueType font cache extension client library"
DEPENDS += "libxext fontcacheproto"
FILE_PR = "r1"
PE = "1"

XORG_PN = "libXfontcache"
