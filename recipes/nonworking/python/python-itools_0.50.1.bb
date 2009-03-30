DESCRIPTION = "itools is a python web technologies library"
SECTION = "devel/python"
HOMEPAGE = "http://www.ikaaro.org/itools"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "itools"
PR = "ml0"

SRC_URI = "http://download.ikaaro.org/itools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
