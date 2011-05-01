DESCRIPTION = "API Extractor is a tool that eases the development of bindings \
of Qt-based libraries for high level languages by automating most of the process."
HOMEPAGE = "http://www.pyside.org"
LICENSE = "LGPL"
DEPENDS = "qt4-native"
PR = "r0"

SRC_URI = "http://www.pyside.org/files/apiextractor-${PV}.tar.bz2"
S = "${WORKDIR}/apiextractor-${PV}"

SRC_URI[md5sum] = "946e8988e5f4c4bd62e774407fa80fee"
SRC_URI[sha256sum] = "82c6c24dc55458ed047eba9fe700894a3347cd53462b21a97b7b5f9180b2a896"

inherit cmake native

