require xorg-lib-common.inc
DESCRIPTION = "X11 damaged region extension library"
LICENSE = "BSD-X"
DEPENDS += "damageproto libxfixes"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "44774e1a065158b52f1a0da5100cebec"
SRC_URI[archive.sha256sum] = "bc6169c826d3cb17435ca84e1b479d65e4b51df1e48bbc3ec39a9cabf842c7a8"

XORG_PN = "libXdamage"
