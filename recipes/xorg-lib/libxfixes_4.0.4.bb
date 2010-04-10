require xorg-lib-common.inc

DESCRIPTION = "X Fixes extension library."
LICENSE= "BSD-X"
DEPENDS += "virtual/libx11 xproto fixesproto xextproto"
PE = "1"

XORG_PN = "libXfixes"

SRC_URI[archive.md5sum] = "7f2c40852eb337b237ad944ca5c30d49"
SRC_URI[archive.sha256sum] = "ba31d7e5c5c1907c30cba50bfd669aa7fe860555287c29f6e786612e4be33b48"
