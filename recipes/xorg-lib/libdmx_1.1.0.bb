require xorg-lib-common.inc

DESCRIPTION = "X11 Distributed Multihead extension library"
DEPENDS += "libxext dmxproto"
PR = "r1"
PE = "1"

SRC_URI[archive.md5sum] = "a2fcf0382837888d3781b714489a8999"
SRC_URI[archive.sha256sum] = "1904a8f848cc5d76105cb07707890aca095540a37fb0a63d359f71da51d3e2d5"
