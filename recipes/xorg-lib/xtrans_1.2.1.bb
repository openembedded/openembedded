require xorg-lib-common.inc
DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
RDEPENDS_${PN}-dev = ""
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "96e142331edd498a9364887b2548f1bb"
SRC_URI[archive.sha256sum] = "9ff21a8d9ea524ca9b7cb6d6b4d522b4cb20b1c35edeb8995a9e9265a0df64bd"

FILESPATHPKG .= ":xtrans-${PV}:xtrans"

ALLOW_EMPTY = "1"

BBCLASSEXTEND = "native nativesdk"
