DESCRIPTION = "Cython is a language specially designed for writing Python extension modules. \
It's designed to bridge the gap between the nice, high-level, easy-to-use world of Python \
and the messy, low-level world of C."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "Cython"
PR = "ml0"

SRC_URI = "http://www.cython.org/release/${SRCNAME}-${PV}.tar.gz;name=archive"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[archive.md5sum] = "f73ad2258115c92ce982d34d27580076"
SRC_URI[archive.sha256sum] = "90d611aeff8d017a5ccca3b1e02ec8d6dd0efc7dfd29806f721bc718d3774ea3"

inherit distutils
