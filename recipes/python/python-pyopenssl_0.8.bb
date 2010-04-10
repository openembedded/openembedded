DESCRIPTION = "Simple Python wrapper around the OpenSSL library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pyOpenSSL"
DEPENDS = "openssl"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyopenssl/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

RDEPENDS = "python-threading"


SRC_URI[md5sum] = "00377690f224d9e59c833fb0459603f4"
SRC_URI[sha256sum] = "2284411d21f1031f08f23c4f49dc0a341e38b07833495d0fe21a87eb25f3ffe3"
