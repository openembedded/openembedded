DESCRIPTION = "A collection of cryptographic algorithms and protocols"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "gmp"
SRCNAME = "pycrypto"
LICENSE = "pycrypto"
PR = "ml0"

PV = "2.0.1+gitr${SRCPV}"
PE = "1"
SRC_URI = "git://git.pycrypto.org:9419/crypto/pycrypto-2.x.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit distutils
