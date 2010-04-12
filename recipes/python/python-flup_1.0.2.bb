DESCRIPTION = "Random assortment of WSGI servers"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "flup"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

SRC_URI[md5sum] = "24dad7edc5ada31dddd49456ee8d5254"
SRC_URI[sha256sum] = "4bad317a5fc1ce3d4fe5e9b6d846ec38a8023e16876785d4f88102f2c8097dd9"
