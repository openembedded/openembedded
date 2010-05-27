DESCRIPTION = "A collection of cryptographic algorithms and protocols"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "gmp"
SRCNAME = "pycrypto"
LICENSE = "pycrypto"
PR = "ml0"

SRCREV = "d087280d7e9643a3e3f68f209932119fe6738b3c"
PV = "2.0.1+gitr${SRCREV}"
SRC_URI = "git://git.pycrypto.org:9419/crypto/pycrypto-2.x.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit distutils
