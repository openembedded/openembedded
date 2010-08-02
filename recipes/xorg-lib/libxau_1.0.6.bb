require xorg-lib-common.inc
DESCRIPTION = "A Sample Authorization Protocol for X"
DEPENDS += " xproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4a2cbd83727682f9ee1c1e719bac6adb"
SRC_URI[archive.sha256sum] = "ee84415ffedcc1c0d39b3a39c35d0596c89907bba93d22bf85e24d21f90170fc"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXau"
