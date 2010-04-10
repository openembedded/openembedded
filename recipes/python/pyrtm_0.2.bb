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

SRC_URI[md5sum] = "34423f39caf7df8a9db8e243be9cf1a0"
SRC_URI[sha256sum] = "d9d46d096a38cb692b55f4ee9f364d54348298e9497b11c1ef057539b5de1567"
