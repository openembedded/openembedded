DESCRIPTION = "Shiboken is a plugin (front-end) for Generator Runner and a runtime library. It generates \
bindings for C++ libraries using CPython source code."
HOMEPAGE = "http://www.pyside.org"
LICENSE = "LGPL"
INC_PR = "r1"

DEPENDS = "apiextractor-native generatorrunner-native"

SRC_URI = "http://www.pyside.org/files/shiboken-${PV}.tar.bz2"
S = "${WORKDIR}/shiboken-${PV}"

# The following exports are needed to let the cmake build configuration succeed without
# errors when detecting the correct python version
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR


