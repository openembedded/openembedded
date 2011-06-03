require xorg-proto-common.inc
DESCRIPTION = "DRI2 extension headers"
PR = "${INC_PR}.1"

SRC_URI += "file://f3c211e1ae183dab5c7529814c9f42af2c29fc6c.patch"

SRC_URI[archive.md5sum] = "0cdeb1e95901813385dc9576be272bd3"
SRC_URI[archive.sha256sum] = "ff156f178d48ab31beeb4be5eb39d5df7540791ba489a8d94c443bb99a2376f1"
