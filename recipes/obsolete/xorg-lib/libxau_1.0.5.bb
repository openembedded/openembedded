require xorg-lib-common.inc
DESCRIPTION = "A Sample Authorization Protocol for X"
DEPENDS += " xproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "993b3185c629e4b89401fca072dcb663"
SRC_URI[archive.sha256sum] = "a503b3e88d29fa9c45cce1b2d1af54106c2ce21491348c394e251a071d8108ee"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXau"
