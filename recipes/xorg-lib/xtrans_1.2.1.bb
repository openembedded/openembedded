require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"
PR = "r0"

ALLOW_EMPTY = "1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xtrans"

RDEPENDS_${PN}-dev = ""

XORG_PN = "xtrans"

SRC_URI[archive.md5sum] = "96e142331edd498a9364887b2548f1bb"
SRC_URI[archive.sha256sum] = "9ff21a8d9ea524ca9b7cb6d6b4d522b4cb20b1c35edeb8995a9e9265a0df64bd"
