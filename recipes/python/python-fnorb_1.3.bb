DESCRIPTION = "A Pure Python CORBA 2.0 Package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "FNORB"
SRCNAME = "Fnorb"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/fnorb/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "7de1500c7ef6592a603890b45e23261b"
SRC_URI[sha256sum] = "d4380ab7fa8b8a9f564592b4e07c96117abd2d3f677b8a73c824cf4f904aa294"
