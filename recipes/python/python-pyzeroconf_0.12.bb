DESCRIPTION = "A pure Python implementation of Zeroconf"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyzeroconf/pyzeroconf-${PV}.tgz"
S = "${WORKDIR}/pyzeroconf-${PV}"

inherit distutils-base

do_install() {
   install -d ${D}${libdir}
   install -d ${D}${libdir}/${PYTHON_DIR}
   install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

   install -m 0644 Zeroconf.py ${D}${libdir}/${PYTHON_DIR}/site-packages/
}

SRC_URI[md5sum] = "e7180e9440d961c6aba5056fdd7997f0"
SRC_URI[sha256sum] = "00689fa56dd87eb47b30565ab7561c94d2cde58372e267116889d2531d880b98"
