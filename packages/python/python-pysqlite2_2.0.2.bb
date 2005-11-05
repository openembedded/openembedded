DESCRIPTION = "A Python extension for the SQLite Embedded Relational Database"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
RDEPENDS = "python-core python-re python-lang"
DEPENDS = "sqlite3"
SRCNAME = "pysqlite"
PR = "ml0"

SRC_URI = "http://initd.org/pub/software/pysqlite/releases/2.0/${PV}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
