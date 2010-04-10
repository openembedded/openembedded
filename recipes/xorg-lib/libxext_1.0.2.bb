require xorg-lib-common.inc
PE = "1"

DESCRIPTION = "X Server Extension library"
PRIORITY = "optional"

DEPENDS += " xproto virtual/libx11 xextproto libxau"
PROVIDES = "xext"

XORG_PN = "libXext"


SRC_URI[archive.md5sum] = "cce89c5b941a493512b534f4847c6111"
SRC_URI[archive.sha256sum] = "368e4cf5117febd998e6fc40d096b3af19a571adccc5ed49b9d16e482b3a8f8e"
