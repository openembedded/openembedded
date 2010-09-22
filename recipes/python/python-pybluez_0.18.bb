DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://pybluez.googlecode.com/files/PyBluez-${PV}.tar.gz"
S = "${WORKDIR}/PyBluez-${PV}"

inherit distutils

SRC_URI[md5sum] = "be8c8ce615c3189fda1aaf3d568314b2"
SRC_URI[sha256sum] = "66b2184e0eaad5e1ecc89eb4c81cba0696b3028b85d1301186b45b0bbd761065"
