DESCRIPTION = "A sophisticated XML Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
RDEPENDS = "python-xml python-netclient"
SRCNAME = "pyxml"
FILE_PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyxml/PyXML-${PV}.tar.gz"
S = "${WORKDIR}/PyXML-${PV}"

inherit distutils

