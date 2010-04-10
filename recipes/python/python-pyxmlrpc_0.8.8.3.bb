DESCRIPTION = "Fast Python XMLRPC Library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "py-xmlrpc"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "d2aa74615aa9cf23413975a68613ffc1"
SRC_URI[sha256sum] = "12527f130dd695184c44c6197deb619c26c9b5b31ce7699a5dd97e0ad2dd7bd1"
