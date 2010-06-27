require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- keyboard input driver"
DEPENDS += " kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "d6fe929c4f6085d6dd67f197ae9c42f6"
SRC_URI[archive.sha256sum] = "33939ec65dbf56f49e1e7de854a1cf95446e40c533950431901567e67112aef2"
