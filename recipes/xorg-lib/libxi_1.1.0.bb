require xorg-lib-common.inc
PE = "1"

DESCRIPTION = "X Input extension library."

DEPENDS += " xproto virtual/libx11 xextproto libxext inputproto"

XORG_PN = "libXi"


SRC_URI[archive.md5sum] = "c25abbe604029855eb11a3a75fb1f386"
SRC_URI[archive.sha256sum] = "0f90d7e27d8a7d6bccf9350b6283ffe122e5347fa51d4ea9055653b297339989"
