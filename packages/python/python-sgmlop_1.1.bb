DESCRIPTION = "Pythonware Fast SGML Parser for Python"
SECTION = "devel/python"
PRIORITY = "optional"
SRCNAME = "sgmlop"
LICENSE = "python-sgmlop"
SRC_URI = "http://www.vanille.de/mirror/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
