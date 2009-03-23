DESCRIPTION = "A Pure Python CORBA 2.0 Package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "FNORB"
SRCNAME = "Fnorb"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/fnorb/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
