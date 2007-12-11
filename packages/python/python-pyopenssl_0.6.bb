DESCRIPTION = "Simple Python wrapper around the OpenSSL library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pyOpenSSL"
DEPENDS = "openssl"
RDEPENDS = "python-threading"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyopenssl/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
