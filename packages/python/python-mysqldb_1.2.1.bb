DESCRIPTION = "Python interface to MySQL"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "mysql"
SRCNAME = "MySQL-python"

inherit distutils

SRC_URI = "${SOURCEFORGE_MIRROR}/mysql-python/MySQL-python-${PV}_p2.tar.gz \
file://mysqlpath.patch;patch=1 \
file://site.patch;patch=1"

S = "${WORKDIR}/${SRCNAME}-${PV}_p2"

do_install_append() {
    install -d ${D}${datadir}/doc/${PN}/
    install -m 0644 ${S}/doc/*.txt ${D}${datadir}/doc/${PN}/
}
