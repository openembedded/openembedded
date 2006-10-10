DESCRIPTION = "A Pure Python CORBA Package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "FNORB"
SRCNAME = "Fnorb"

SRC_URI = "${SOURCEFORGE_MIRROR}/fnorb/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

