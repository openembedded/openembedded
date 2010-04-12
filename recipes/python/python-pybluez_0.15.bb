DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://pybluez.googlecode.com/files/PyBluez-0.15.tar.gz"
S = "${WORKDIR}/PyBluez-${PV}"

inherit distutils

SRC_URI[md5sum] = "104ad743d4bc999796ceff4f39d1003a"
SRC_URI[sha256sum] = "593912fdf122d9a1499767bc305ca7b3b688ace7edcb93f53e07202aa1242c58"
