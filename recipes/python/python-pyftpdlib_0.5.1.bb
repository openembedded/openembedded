DESCRIPTION = "FTP Server Library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml0"

inherit distutils

SRC_URI = "http://pyftpdlib.googlecode.com/files/pyftpdlib-${PV}.tar.gz"
S = "${WORKDIR}/pyftpdlib-${PV}"

RDEPENDS = "python-netserver"
