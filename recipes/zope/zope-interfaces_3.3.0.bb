DESCRIPTION = "Interface definitions for Zope products"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "ZPL"

inherit distutils

SRC_URI = "http://pypi.python.org/packages/source/z/zope.interface/zope.interface-${PV}.tar.gz"
S = "${WORKDIR}/zope.interface-${PV}"
