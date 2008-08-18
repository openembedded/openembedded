DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
SRC_URI = "http://pybluez.googlecode.com/files/PyBluez-${PV}.tar.gz"

S = "${WORKDIR}/PyBluez-${PV}"

PR = "ml0"

inherit distutils
