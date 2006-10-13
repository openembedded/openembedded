DESCRIPTION = "libcurl Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
RDEPENDS = "python-core curl (>=${PV})"
DEPENDS = "curl-${PV}"
SRCNAME = "pycurl"

SRC_URI = "http://${SRCNAME}.sourceforge.net/download/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
