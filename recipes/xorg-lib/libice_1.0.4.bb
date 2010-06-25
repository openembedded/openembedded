require xorg-lib-common.inc
DESCRIPTION = "X11 Inter-Client Exchange library"
DEPENDS += "xproto xtrans"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4ab4e67e0b8845aa201e984153087f4a"
SRC_URI[archive.sha256sum] = "13055e2f4c645cbd135ce97a7974a5866f9ba3ed8988e686b552f55c30514f04"

BBCLASSEXTEND = "native"

XORG_PN = "libICE"
