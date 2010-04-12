require xorg-lib-common.inc

DESCRIPTION = "network API translation layer to insulate X applications and \
libraries from OS network vageries."
PE = "1"
PR = "r0"

ALLOW_EMPTY = "1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xtrans"

RDEPENDS_${PN}-dev = ""

XORG_PN = "xtrans"

SRC_URI[archive.md5sum] = "f9cf791dfad59cf044e276aab3a71e1d"
SRC_URI[archive.sha256sum] = "a67a8b09d9530021e2bd4b93136f385e72a8d8e4f2c26a99aeb169bee88facf0"
