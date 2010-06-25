require xorg-lib-common.inc
DESCRIPTION = "X Fixes extension library."
LICENSE = "BSD-X"
DEPENDS += "virtual/libx11 xproto fixesproto xextproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1b4b8386bd5d1751b2c7177223ad4629"
SRC_URI[archive.sha256sum] = "2e6cd020460e4ef5d5a1d9b5d21143e9f5e580036a79c7de26ae539d7bcb8d74"

BBCLASSEXTEND = "native"

XORG_PN = "libXfixes"
