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

SRC_URI[md5sum] = "ec7eee3444214bda18e57b82175e1da7"
SRC_URI[sha256sum] = "019b6d4b549306d013974678872aaf2453af3f02760175504dbe8a9f89db0a2c"
