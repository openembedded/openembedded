require xorg-lib-common.inc

DESCRIPTION = "X11 Inter-Client Exchange library"
DEPENDS += "xproto xtrans"
PROVIDES = "ice"
PR = "r1"
PE = "1"

XORG_PN = "libICE"

SRC_URI[archive.md5sum] = "071f96648ac25c8e87a3de11a7de2d8a"
SRC_URI[archive.sha256sum] = "ffd46270dae30cad147d73559142a701a8ff8d0658f4abfb2341edefabb8161d"
