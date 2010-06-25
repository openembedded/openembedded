require xorg-lib-common.inc
DESCRIPTION = "XFIXES Extension"
DEPENDS += " xextproto xproto zlib"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://mkg3states-1.1.patch"
SRC_URI[archive.md5sum] = "273329a78c2e9ea189ac416c7fde94a1"
SRC_URI[archive.sha256sum] = "c6b6ff7858ec619cafa8205debca6bf78c5610a2844a782ed643c7fd017cf8ae"

export CC_FOR_BUILD = "gcc"
