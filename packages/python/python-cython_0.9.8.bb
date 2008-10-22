DESCRIPTION = "Cython is a language specially designed for writing Python extension modules. \
It's designed to bridge the gap between the nice, high-level, easy-to-use world of Python \
and the messy, low-level world of C."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "Cython"
PR = "ml1"

SRC_URI = "http://www.cython.org/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

