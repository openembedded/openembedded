DESCRIPTION = "iniparse is a INI parser for Python"
HOMEPAGE = "http://code.google.com/p/iniparse/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://iniparse.googlecode.com/files/iniparse-${PV}.tar.gz"
S = "${WORKDIR}/iniparse-${PV}"

inherit distutils

SRC_URI[md5sum] = "194a04cc93fe123f244ca33e7724bdf6"
SRC_URI[sha256sum] = "f1252122f09cc63a57843ec1b8a51ce30c7bfcbc857f476a996b374006433a48"
