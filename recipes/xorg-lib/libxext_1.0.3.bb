require xorg-lib-common.inc

DESCRIPTION = "X11 miscellaneous extension library"
DEPENDS += "xproto virtual/libx11 xextproto libxau"
PROVIDES = "xext"
PR = "r1"
PE = "1"

XORG_PN = "libXext"

SRC_URI[archive.md5sum] = "1bf6fa1c26f9957d7cc0bd90b038dfa6"
SRC_URI[archive.sha256sum] = "2d706baf206d1cb422c8e0ceb6c5a8546bc3f0587cf090eba51e75a295d9c3f0"
