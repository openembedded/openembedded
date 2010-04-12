DESCRIPTION = "The eGenix.com mx Extensions for Python are a collection of professional quality Python software \
tools which enhance Python's usability in many important areas such as ODBC database connectivity, fast text \
processing, date/time processing and web site programming."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "EGENIX"
SRCNAME = "egenix-mx-base"
PR = "ml0"

SRC_URI = "http://downloads.egenix.com/python/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export INCLUDE = "${STAGING_INCDIR}/${PYTHON_DIR}"
export LIB = "${STAGING_LIBDIR}"

FILES_${PN} += "${datadir}"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/mx/*/*/.debug"

SRC_URI[md5sum] = "d0f3b1adca33a68867bf50f000060cd6"
SRC_URI[sha256sum] = "a0d03208e335610defc3049d8dd03f4ec7fcf477f44c4897b3f68adc478237ee"
