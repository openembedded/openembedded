DESCRIPTION = "Google Data APIs Python Client Library"
SECTION = "devel/python"
LICENSE = "Apache"
HOMEPAGE = "http://code.google.com/p/gdata-python-client/"
PR = "r0"

inherit distutils

SRC_URI = "http://gdata-python-client.googlecode.com/files/gdata.py-${PV}.tar.gz"
S = "${WORKDIR}/gdata.py-${PV}"

FILES_${PN} += "${datadir}"

RDEPENDS = "python-elementtree"

