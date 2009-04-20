DESCRIPTION = "Extensions to the standard Python date/time support"
HOMEPAGE = "http://labix.org/python-dateutil"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "python-dateutil"
PR = "0"

SRC_URI = "http://labix.org/download/python-dateutil/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS = "\
  python-core \
  python-datetime \
"

