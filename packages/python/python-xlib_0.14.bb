DESCRIPTION = "Python Bindings for X Library"
HOMEPAGE = "http://sourceforge.net/projects/python-xlib/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit distutils
