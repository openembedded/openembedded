DESCRIPTION = "Interface definitions for Zope products"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "ZPL"

RPROVIDES_${PN} += " zope-interfaces"

inherit distutils

PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/z/zope.interface/zope.interface-${PV}.tar.gz"
S = "${WORKDIR}/zope.interface-${PV}"

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"  
