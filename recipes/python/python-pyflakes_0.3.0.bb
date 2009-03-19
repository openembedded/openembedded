DESCRIPTION = "Python Source-Code Testing Utility"
SECTION = "devel/python"
HOMEPAGE = "http://divmod.org/projects/pyflakes"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "pyflakes"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/p/pyflakes/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
