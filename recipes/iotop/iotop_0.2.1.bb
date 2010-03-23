HOMEPAGE = "http://guichaz.free.fr/iotop/"
LICENSE = "GPL"
PR = "r2"

RDEPENDS = "python-distutils python-curses python-setuptools python-textutils"

SRC_URI = "http://guichaz.free.fr/iotop/files/${PN}-${PV}.tar.bz2"

inherit distutils

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}
