DESCRIPTION = "Python interface to SQLite 3"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "sqlite3"
SRCNAME = "pysqlite"
PR = "ml1"

SRC_URI = "http://initd.org/pub/software/pysqlite/releases/2.4/${PV}/${SRCNAME}-${PV}.tar.gz \
           file://fix-setup.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_append() {
    install -d ${D}${datadir}/doc/
    mv ${D}${datadir}/pysqlite2-doc ${D}${datadir}/doc/${PN}
}

RDEPENDS = "\
 python-datetime \
 python-lang \
 python-crypt \
 python-io \
 python-threading \
 python-unittest \
 python-zlib \
"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${libdir}/${PYTHON_DIR}/pysqlite2/test"
RDEPENDS_${PN}-tests = "${PN}"
