DESCRIPTION = "The eGenix.com mx Extensions for Python are a collection of professional quality Python software \
tools which enhance Python's usability in many important areas such as ODBC database connectivity, fast text \
processing, date/time processing and web site programming."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "EGENIX"
SRCNAME = "egenix-mx-base"

SRC_URI = "http://www.egenix.com/files/python/egenix-mx-base-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

FILES_${PN} += "${datadir}"
