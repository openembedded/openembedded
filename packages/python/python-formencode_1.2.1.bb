DESCRIPTION = "HTML form validation, generation, and conversion package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "FormEncode"
PR = "ml0"

inherit setuptools

SRC_URI = "http://pypi.python.org/packages/source/F/FormEncode/FormEncode-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"
