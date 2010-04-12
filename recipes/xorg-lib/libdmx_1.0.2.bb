require xorg-lib-common.inc

DESCRIPTION = "X11 Distributed Multihead extension library"
DEPENDS += "libxext dmxproto"
PR = "r1"
PE = "1"

SRC_URI[archive.md5sum] = "4d866967210d06098fc9f302ed4c79b1"
SRC_URI[archive.sha256sum] = "fa3ff31a543f7cea04762c08f48b418e75230de8b4dfdf9d2d3ae9e2af26b9c4"
