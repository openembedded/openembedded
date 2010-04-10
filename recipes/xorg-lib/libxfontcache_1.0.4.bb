require xorg-lib-common.inc

DESCRIPTION = "X-TrueType font cache extension client library"
DEPENDS += "libxext fontcacheproto"
PR = "r1"
PE = "1"

XORG_PN = "libXfontcache"

SRC_URI[archive.md5sum] = "1adca018aa7bf2d215f20a69c10828ad"
SRC_URI[archive.sha256sum] = "ffe747cfbf81cdd862af1b05d021ad1ab83b623eab5b32b0a618efb4c0f3e01c"
