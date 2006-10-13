DESCRIPTION = "itools is a python web technologies library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
RDEPENDS = "python-core"
SRCNAME = "itools"

SRC_URI = "http://www.ikaaro.org/download/itools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
