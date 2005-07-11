DESCRIPTION = "Python bindings for the Linux Bluetooth stack"
MAINTAINER = "Michael 'Mickey' Lauer"
SECTION = "devel/python"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
SRC_URI = "http://org.csail.mit.edu/pybluez/release/pybluez-src-${PV}.tar.gz"

S = "${WORKDIR}/pybluez-${PV}"

PR = "ml0"

inherit distutils
