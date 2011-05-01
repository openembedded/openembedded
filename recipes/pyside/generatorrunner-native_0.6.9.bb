DESCRIPTIOu = "GeneratorRunner is a tool that eases the development of binding generators for C++ and Qt-based libraries by \
providing a framework to help automating most of the process. It uses the ApiExtractor library to parse the header files and \
manipulate the classes information while generating the binding code using front-end modules provided by the user."
HOMEPAGE = "http://www.pyside.org"
LICENSE = "LGPL"
DEPENDS = "apiextractor-native"
PR = "r0"

SRC_URI = "http://www.pyside.org/files/generatorrunner-${PV}.tar.bz2"
S = "${WORKDIR}/generatorrunner-${PV}"

SRC_URI[md5sum] = "b99c5564104a56147806d467ff1a187b"
SRC_URI[sha256sum] = "4801d24b90966fa18696b8445c7f9f4d1f93551617dd4807a3609b49c0d93e34"

inherit cmake native
