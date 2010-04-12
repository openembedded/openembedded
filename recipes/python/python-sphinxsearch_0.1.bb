DESCRIPTION = "A module for querying the sphinx search daemon"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.sphinxsearch.com/"
SRCNAME = "sphinxsearch"
PR = "ml1"

SRC_URI = "http://pypi.python.org/packages/source/s/sphinxsearch/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "920deac1bd4d16fe1c5b51fe839140ab"
SRC_URI[sha256sum] = "7fcf0aa2e5e08719b39aeb145d3b6e953a8643bb6fd5e8359303399493ee6c39"
