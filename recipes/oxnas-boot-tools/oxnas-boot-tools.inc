DESCRIPTION = "Boot tools for OXNAS boards"
INC_PR = "r0"

SRC_URI = "file://oxnas-boot-tools-${PV}.tar.gz"

inherit autotools

BBCLASSEXTEND = "native"
