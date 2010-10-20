require xorg-lib-common.inc
DESCRIPTION = "X11 Inter-Client Exchange library"
DEPENDS += "xproto xtrans"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bb72a732b15e9dc25c3036559387eed5"
SRC_URI[archive.sha256sum] = "a8b1692f151a473cee8733df9aefe98f7e5f64dfe6d4213cb6231d7bf855b901"

BBCLASSEXTEND = "native"

XORG_PN = "libICE"
