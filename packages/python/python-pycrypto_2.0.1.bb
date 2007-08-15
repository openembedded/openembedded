DESCRIPTION = "A collection of cryptographic algorithms and protocols"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "gmp"
SRCNAME = "pycrypto"
LICENSE = "pycrypto"
PR = "ml0"

SRC_URI = "http://www.amk.ca/files/python/crypto/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
