DESCRIPTION = "A pure Python implementation of Zeroconf"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyzeroconf/pyzeroconf-${PV}.tgz"

S = "${WORKDIR}/pyzeroconf-${PV}"

inherit distutils-base

do_install() {

   install -d ${D}${libdir}
   install -d ${D}${libdir}/${PYTHON_DIR}
   install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

   install -m 0644 Zeroconf.py ${D}${libdir}/${PYTHON_DIR}/site-packages/
}
