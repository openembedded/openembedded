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


SRC_URI[md5sum] = "521f33a377d64f8a6505ba119415b787"
SRC_URI[sha256sum] = "fc5ddb8f76b17abd728721a0e0177ea35f55a70106f44dc9010b22eceb06abde"
