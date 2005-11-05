DESCRIPTION = "A Pure Python SNMP Package"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
RDEPENDS = "python-core"
SRCNAME = "libsnmp"
LICENSE = "LGPL"
SRC_URI = "http://seafelt.unicity.com.au/downloads/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

