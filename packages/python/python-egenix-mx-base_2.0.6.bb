DESCRIPTION = "The eGenix.com mx Extensions for Python are a collection of professional quality Python software \
tools which enhance Python's usability in many important areas such as ODBC database connectivity, fast text \
processing, date/time processing and web site programming."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "EGENIX"
SRCNAME = "egenix-mx-base"
PR = "r1"

SRC_URI = "http://www.egenix.com/files/python/egenix-mx-base-${PV}.tar.gz \
           file://gcc4.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export INCLUDE = "${STAGING_INCDIR}/${PYTHON_DIR}"
export LIB = "${STAGING_LIBDIR}"

FILES_${PN} += "${datadir}"
