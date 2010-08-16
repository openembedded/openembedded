require xorg-lib-common.inc
DESCRIPTION = "X11 Inter-Client Exchange library"
DEPENDS += "xproto xtrans"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "071f96648ac25c8e87a3de11a7de2d8a"
SRC_URI[archive.sha256sum] = "ffd46270dae30cad147d73559142a701a8ff8d0658f4abfb2341edefabb8161d"

BBCLASSEXTEND = "native"

XORG_PN = "libICE"
