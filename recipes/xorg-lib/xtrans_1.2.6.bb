require xorg-lib-common.inc
DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
RDEPENDS_${PN}-dev = ""
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "c66f9ffd2da4fb012220c6c40ebc7609"
SRC_URI[archive.sha256sum] = "c5f9a73705ddbb8c9b8f16c4fac33b4b9ba7661b8305474b4c1549e48d9ca5c6"

ALLOW_EMPTY = "1"

BBCLASSEXTEND = "native nativesdk"
