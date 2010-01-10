DESCRIPTION = "Python interface for Remember The Milk API."
AUTHOR = "Sridhar Ratnakumar / srid"
HOMEPAGE = "http://pypi.python.org/pypi/pyrtm"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "python-native"
PR = "r0"

SRC_URI = "http://pypi.python.org/packages/source/p/pyrtm/pyrtm-${PV}.tar.gz"

SRCNAME = "pyrtm"

inherit distutils

PACKAGE_ARCH = "all"
