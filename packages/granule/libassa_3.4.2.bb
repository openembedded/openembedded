DESCRIPTION = "Object-oriented C++ networking library based on Adaptive Communication Patterns."
AUTHOR = "Vladislav Grinchenko <vlg@users.sourceforge.net>"
HOMEPAGE = "http://libassa.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
FILE_PR = "r0"


SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}-2.tar.gz"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}
