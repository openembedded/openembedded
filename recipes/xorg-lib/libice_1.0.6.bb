require xorg-lib-common.inc

DESCRIPTION = "X11 Inter-Client Exchange library"
DEPENDS += "xproto xtrans"
PROVIDES = "ice"
PR = "r1"
PE = "1"

XORG_PN = "libICE"

SRC_URI[archive.md5sum] = "2d39bc924af24325dae589e9a849180c"
SRC_URI[archive.sha256sum] = "a8346859505d2aa27ecc4531f1c86d72801936d96c31c5beaeff4587441b568b"
