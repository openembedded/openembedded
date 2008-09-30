DESCRIPTION = "Python Bindings for X Library"
HOMEPAGE = "http://sourceforge.net/projects/python-xlib/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = ""
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRCNAME = "python-xlib"

inherit distutils
