DESCRIPTION = "zope.interface is provides Zope 3-styled interface definitions \
for python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "ZPL"
SRCNAME = "zope.interface"

SRC_URI = "http://www.zope.org/Products/ZopeInterface/${PV}/${SRCNAME}-${PV}.tar.gz"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
