DESCRIPTION = "HTML form validation, generation, and conversion package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
SRCNAME = "FormEncode"
PV = "0.4+svn${SRCDATE}"
PR = "ml0"

inherit distutils

SRC_URI = "svn://svn.colorstudy.com/FormEncode;module=trunk;proto=http \
           file://setup.py.diff;patch=1"

S = "${WORKDIR}/trunk"
