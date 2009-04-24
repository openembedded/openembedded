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
