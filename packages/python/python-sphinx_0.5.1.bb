DESCRIPTION = "Python documentation generator"
SECTION = "devel/python"
LICENSE = "BSD"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/S/Sphinx/Sphinx-${PV}.tar.gz"
S = "${WORKDIR}/Sphinx-${PV}"

inherit distutils
