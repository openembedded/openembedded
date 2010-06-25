require xorg-lib-common.inc
DEPENDS += "libxext windowswmproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "337b379fd00a67345b083100c4e6ba95"
SRC_URI[archive.sha256sum] = "6ad87266173d21ba7e0e4506db0c094769fd58c3f0b741b37f30c297deec166a"

XORG_PN = "libWindowsWM"
