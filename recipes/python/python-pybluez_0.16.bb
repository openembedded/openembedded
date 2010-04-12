DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://pybluez.googlecode.com/files/PyBluez-${PV}.tar.gz"
S = "${WORKDIR}/PyBluez-${PV}"

inherit distutils

SRC_URI[md5sum] = "2ce8ff0dbb94c6be14e92e9968f4c914"
SRC_URI[sha256sum] = "cbe1f076a4947e29ded08ba9dd6dbbb86b25939fb4e50f508dd02f41681554e2"
