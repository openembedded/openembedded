DESCRIPTION = "Python interface to MySQL"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "mysql"
SRCNAME = "MySQL-python"

inherit distutils

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/mysql-python/MySQL-python-${PV}_p2.tar.gz \
  file://mysqlpath.patch;patch=1 \
  file://site.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}_p2"

do_install_append() {
    install -d ${D}${datadir}/doc/${PN}/
    install -m 0644 ${S}/doc/*.txt ${D}${datadir}/doc/${PN}/
}

SRC_URI[md5sum] = "e6b9ea21fd91cb4a5663304da727bb70"
SRC_URI[sha256sum] = "59f44cd53cfa1189dcaa5bf2c48662d5765f347b03827feb807f4cd0ef18943e"
