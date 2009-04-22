DESCRIPTION = "Extensions to the standard Python date/time support"
HOMEPAGE = "http://labix.org/python-dateutil"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "${PN}"
PR = "r1"

SRC_URI = "http://labix.org/download/python-dateutil/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

PACKAGES =+ "${PN}-zoneinfo"
FILES_${PN}-zoneinfo = "${libdir}/${PYTHON_DIR}/site-packages/dateutil/zoneinfo"

RDEPENDS_${PN} = "\
  python-core \
  python-datetime \
"
