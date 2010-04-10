DESCRIPTION = "cups Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "cups"
SRCNAME = "pycups"

SRC_URI = "http://cyberelk.net/tim/data/pycups/pycups-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# used during compilation
CFLAGS += -DVERSION=\\"${PV}\\"

RDEPENDS = "python-core cups"

SRC_URI[md5sum] = "ff634a6751f8a859ed26751bf03abef0"
SRC_URI[sha256sum] = "ef6e576e5465da9c338ac8ff9f162825cfb7997359efc52e6a110c295a9f363b"
