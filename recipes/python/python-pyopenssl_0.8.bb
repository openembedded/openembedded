DESCRIPTION = "Simple Python wrapper around the OpenSSL library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pyOpenSSL"
DEPENDS = "openssl"
PR = "ml2"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyopenssl/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${libdir}/${PYTHON_DIR}/site-packages/OpenSSL/test"

RDEPENDS_${PN} = "python-threading"
RDEPENDS_${PN}-tests = "${PN}"


SRC_URI[md5sum] = "00377690f224d9e59c833fb0459603f4"
SRC_URI[sha256sum] = "2284411d21f1031f08f23c4f49dc0a341e38b07833495d0fe21a87eb25f3ffe3"
