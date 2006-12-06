DESCRIPTION = "A pure Python DAAP client implementation"
SECTION = "devel/python"
PRIORITY = "optional"
RDEPENDS = "python-compression"
LICENSE = "LGPL"

inherit distutils

SRC_URI = "http://jerakeen.org/files/PythonDaap-${PV}.tar.gz"

S = "${WORKDIR}/PythonDaap-${PV}"
