DESCRIPTION = "Python interface to SQLite 3"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "sqlite3"
SRCNAME = "pysqlite"
PR = "ml2"

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

SRC_URI[md5sum] = "46b4590c51b9fb62cd0be1439646549e"
SRC_URI[sha256sum] = "7e66c07d3eb93035f9272d01470e531a7c9f9d9751ad06f3a9c13b4f67c0a06a"
