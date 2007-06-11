DESCRIPTION = "A Python extension for the SQLite Embedded Relational Database"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
RDEPENDS = "python-core python-re python-lang python-datetime"
DEPENDS = "sqlite3"
SRCNAME = "pysqlite2"
PR = "ml2"

SRC_URI = "http://initd.org/pub/software/pysqlite/releases/2.2/${PV}/pysqlite-${PV}.tar.gz"
S = "${WORKDIR}/pysqlite-${PV}"

inherit distutils

do_install_append() {
    install -d ${D}${docdir}/doc
    mv ${D}/${datadir}/pysqlite2-doc ${D}${docdir}/${SRCNAME}
}
