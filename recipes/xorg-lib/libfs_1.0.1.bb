require xorg-lib-common.inc

DESCRIPTION = "X11 Font Services library"
DEPENDS += "xproto fontsproto xtrans"
PE = "1"

XORG_PN = "libFS"

SRC_URI[archive.md5sum] = "81521249353fa33be7a4bb0062c2fbb9"
SRC_URI[archive.sha256sum] = "9bf92ffdb51e69e07682cd1a6c0101f2a833b16b9bfa5d601491ff46a35a2cf5"
