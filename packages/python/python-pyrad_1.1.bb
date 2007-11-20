DESCRIPTION = "Python Radius Client and Server"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
RDEPENDS = "python-crypt"
SRCNAME = "pyrad"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
