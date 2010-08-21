require xorg-lib-common.inc
DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
RDEPENDS_${PN}-dev = ""
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "2d1e57e82acc5f21797e92341415af2f"
SRC_URI[archive.sha256sum] = "cc71a391f4da8176e5daeeac1ddf5137ba5e8d2263cb93a49f9e2a9976b90899"

ALLOW_EMPTY = "1"

BBCLASSEXTEND = "native nativesdk"
