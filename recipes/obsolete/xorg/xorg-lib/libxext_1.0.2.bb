require xorg-lib-common.inc
DESCRIPTION = "X Server Extension library"
PRIORITY = "optional"
DEPENDS += " xproto virtual/libx11 xextproto libxau"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "cce89c5b941a493512b534f4847c6111"
SRC_URI[archive.sha256sum] = "368e4cf5117febd998e6fc40d096b3af19a571adccc5ed49b9d16e482b3a8f8e"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXext"
