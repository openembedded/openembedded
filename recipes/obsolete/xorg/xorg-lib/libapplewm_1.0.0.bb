require xorg-lib-common.inc
DEPENDS += "libxext applewmproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "48a403c45be2206ee900729ced3a0e62"
SRC_URI[archive.sha256sum] = "ecd2ff407a418eb4ac673f48b4d0a9c5b6860a13cef7211a32fe8f3d3db0407e"

XORG_PN = "libAppleWM"
