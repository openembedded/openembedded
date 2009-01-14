DESCRIPTION = "PyXDG is a python library to access freedesktop.org standards"
SECTION = "devel/python"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.freedesktop.org/~lanius/pyxdg-${PV}.tar.gz"
S = "${WORKDIR}/pyxdg-${PV}"

inherit distutils
