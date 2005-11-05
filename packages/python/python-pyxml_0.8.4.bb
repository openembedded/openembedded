DESCRIPTION = "A sophisticated XML Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
RDEPENDS = "python-core python-xml python-netclient"
SRCNAME = "pyxml"
PV = "0.8.3"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyxml/PyXML-${PV}.tar.gz"
S = "${WORKDIR}/PyXML-${PV}"

inherit distutils

