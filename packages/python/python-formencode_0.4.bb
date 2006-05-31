DESCRIPTION = "HTML form validation, generation, and conversion package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
SRCNAME = "FormEncode"

inherit distutils

SRC_URI = "http://cheeseshop.python.org/packages/source/F/FormEncode/FormEncode-${PV}.tar.gz \
file://setup.py.diff;patch=1"

S = "${WORKDIR}/${SRCNAME}-${PV}"
