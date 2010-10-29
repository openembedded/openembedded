require xorg-lib-common.inc
DESCRIPTION = "X11 Distributed Multihead extension library"
DEPENDS += "libxext dmxproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "75fd328fab3bd4a55cccaa6d5dfff749"
SRC_URI[archive.sha256sum] = "a6de6e87470bc749de02056fa38758d0e633303789830fdafc56600e75b3de18"
