DESCRIPTION = "Python Bindings for libphone-utils"
SECTION = "devel/python"
DEPENDS = "libphone-utils python-cython-native python-pyrex-native"
RDEPENDS = "libphone-utils"

SRCREV = "8a7c719e0c3f1f8c10f77f17422da02d7177f0dd"
PV = "0.0.2+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/libphone-utils.git;protocol=http;branch=master"
S = "${WORKDIR}/git/src/python"

inherit setuptools
