DESCRIPTION = "Python Web framework"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
RDEPENDS = "python-email python-netserver python-pickle python-pprint \
	    python-shell python-textutils python-threading python-unixadmin \
	    python-xml"
RRECOMMENDS = "python-pysqlite2"
SRCNAME = "Django"

SRC_URI = "http://media.djangoproject.com/releases/0.96/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DISTUTILS_INSTALL_ARGS = "--root=${D} --prefix=${prefix}"
