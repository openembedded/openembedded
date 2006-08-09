DESCRIPTION = "zope.interface is provides Zope 3-styled interface definitions \
for python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "ZPL"
SRCNAME = "ZopeInterface"

SRC_URI = "http://www.zope.org/Products/${SRCNAME}/${PV}/${SRCNAME}-${PV}.tgz"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
