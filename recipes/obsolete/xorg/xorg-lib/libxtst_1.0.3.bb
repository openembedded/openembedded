require xorg-lib-common.inc
DESCRIPTION = "X Test Extension: client side library"
DEPENDS += "libxext recordproto inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "090c1ad04e34982eada5cf3b1a0792fd"
SRC_URI[archive.sha256sum] = "b4a8dd3d9ceb04cd7322c1f7e5d2320d6ccf85ba8c81d736fd6d6c83c658c905"

XORG_PN = "libXtst"
