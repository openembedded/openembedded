require xorg-lib-common.inc
DESCRIPTION = "X Damage extension library."
LICENSE = "BSD-X"
DEPENDS += " virtual/libx11 damageproto libxfixes fixesproto xextproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4d0eece7a8372a7754db1de08c2be324"
SRC_URI[archive.sha256sum] = "5df90f0efa77e1d6f9e1768a2b0adfc896d09c7a3d8680ed0980511b3625c636"

XORG_PN = "libXdamage"
