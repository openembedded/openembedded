DESCRIPTION = "A module for querying the sphinx search daemon"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.sphinxsearch.com/"
SRCNAME = "sphinxsearch"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/s/sphinxsearch/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
