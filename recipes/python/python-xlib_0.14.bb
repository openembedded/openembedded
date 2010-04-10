DESCRIPTION = "Python Bindings for X Library"
HOMEPAGE = "http://sourceforge.net/projects/python-xlib/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit distutils

SRC_URI[md5sum] = "a038c2f410d8445f3fa8f6dcd45659c5"
SRC_URI[sha256sum] = "4771b0b6a605e0197ece5432fa601c61df724b32544239f463a867200f2160eb"
