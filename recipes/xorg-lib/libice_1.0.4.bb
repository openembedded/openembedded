require xorg-lib-common.inc

DESCRIPTION = "X11 Inter-Client Exchange library"
DEPENDS += "xproto xtrans"
PROVIDES = "ice"
PR = "r1"
PE = "1"

XORG_PN = "libICE"

SRC_URI[archive.md5sum] = "4ab4e67e0b8845aa201e984153087f4a"
SRC_URI[archive.sha256sum] = "13055e2f4c645cbd135ce97a7974a5866f9ba3ed8988e686b552f55c30514f04"
