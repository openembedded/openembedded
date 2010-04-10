DESCRIPTION = "FTP Server Library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml0"

inherit distutils

SRC_URI = "http://pyftpdlib.googlecode.com/files/pyftpdlib-${PV}.tar.gz"
S = "${WORKDIR}/pyftpdlib-${PV}"

RDEPENDS = "python-netserver"

SRC_URI[md5sum] = "f64ac67ebec1d8ab47c0766082617384"
SRC_URI[sha256sum] = "6daed9475412eaab232e021ed76568c6520dacd75c58da406454139bef95c393"
