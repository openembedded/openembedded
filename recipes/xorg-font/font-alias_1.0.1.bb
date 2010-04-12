require xorg-font-common.inc

DESCRIPTION = "X font aliases."

DEPENDS = "virtual/xserver font-util"
RDEPENDS = "encodings font-util"

PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "c4776b6f0f2ecdb7670b6fe64b5d2a2d"
SRC_URI[archive.sha256sum] = "77db60d63224b9d856129d23c0b0d0e9154a166137daf749d39abfd56a4f89b6"
