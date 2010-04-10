DESCRIPTION = "Pythonware Fast SGML Parser for Python"
SECTION = "devel/python"
PRIORITY = "optional"
SRCNAME = "sgmlop"
LICENSE = "${PN}"

inherit distutils

SRC_URI = "http://www.vanille.de/mirror/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "45f77f33a6b2a5c09c28511ebb733b87"
SRC_URI[sha256sum] = "7fd6495d6c3e8dac7ba086c68abed4930c958a94afc15359223074614559e462"
