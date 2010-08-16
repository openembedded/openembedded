require xorg-lib-common.inc
DESCRIPTION = "XFIXES Extension"
DEPENDS += " xextproto xproto zlib"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://mkg3states.patch"
SRC_URI[archive.md5sum] = "b73cbd5bc3cd268722a624a5f1318fde"
SRC_URI[archive.sha256sum] = "94c31c7090106d3a95e2a7c083961efca1321b970118fe103ab06e5d927b7258"

export CC_FOR_BUILD = "gcc"
