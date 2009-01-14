DESCRIPTION = "RPyC is a Remote Procedure Call Package for Python"
SECTION = "devel/python"
HOMEPAGE = "http://rpyc.wikizone.com"
LICENSE = "GPL"
SRCNAME = "rpyc"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/rpyc/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
