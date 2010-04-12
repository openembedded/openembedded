DESCRIPTION = "Object-oriented C++ networking library based on Adaptive Communication Patterns."
AUTHOR = "Vladislav Grinchenko <vlg@users.sourceforge.net>"
HOMEPAGE = "http://libassa.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}

SRC_URI[md5sum] = "9b61dfd94bf4e083829ffb0231243d8b"
SRC_URI[sha256sum] = "72a627c74e82ff679cb16ebe3a625b9032d8d1feed4c1da63ebb5106a80b1314"
