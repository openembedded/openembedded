require xorg-lib-common.inc

DESCRIPTION = "X11 Session management library"
DEPENDS += "libice xproto xtrans"
PR = "r1"
PE = "1"

XORG_PN = "libSM"

SRC_URI[archive.md5sum] = "184cbf502b3cd5d7ba5f9d1290a99606"
SRC_URI[archive.sha256sum] = "57f42d3557effe452cd348362977ff90fa61009885c23b3aca8cb0219b5dec04"
