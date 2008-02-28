DESCRIPTION = "The eGenix.com mx Extensions for Python are a collection of professional quality Python software \
tools which enhance Python's usability in many important areas such as ODBC database connectivity, fast text \
processing, date/time processing and web site programming."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "EGENIX"
SRCNAME = "egenix-mx-base"
PR = "r0"

SRC_URI = "http://downloads.egenix.com/python/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export INCLUDE = "${STAGING_INCDIR}/${PYTHON_DIR}"
export LIB = "${STAGING_LIBDIR}"

FILES_${PN} += "${datadir}"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/mx/*/*/.debug"
