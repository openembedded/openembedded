DESCRIPTION = "HTML form validation, generation, and conversion package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
SRCNAME = "FormEncode"
PV = "0.4+svnr${SRCREV}"
PR = "ml1"

inherit setuptools

SRC_URI = "svn://svn.colorstudy.com/FormEncode;module=trunk;proto=http"

S = "${WORKDIR}/trunk"
