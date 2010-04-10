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

SRC_URI[md5sum] = "127e038106492de258a206433f4c3a96"
SRC_URI[sha256sum] = "c2a7032057f9e1a6515f8062c13b52a6f0b77609677839399521da67dc123b7c"
