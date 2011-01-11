require xorg-lib-common.inc
DESCRIPTION = "X Test Extension: client side library"
DEPENDS += "libxext recordproto inputproto libxi"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "dd6f3e20b87310187121539f9605d977"
SRC_URI[archive.sha256sum] = "bd440f4779e06957211ba83782a5a1cfbf1d42b14fd3510a6dce440489a4eb26"

XORG_PN = "libXtst"
