DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://org.csail.mit.edu/pybluez/release/pybluez-src-${PV}.tar.gz"
S = "${WORKDIR}/pybluez-${PV}"

inherit distutils
