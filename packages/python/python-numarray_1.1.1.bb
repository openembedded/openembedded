DESCRIPTION = "Next Generation sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PYRAF"
SRCNAME = "numarray"

SRC_URI = ${SOURCEFORGE_MIRROR}/numpy/${SRCNAME}-${PV}.tar.gz
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
