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

SRC_URI[archive.md5sum] = "cf9f98e982258f8516620277975016f3"
SRC_URI[archive.sha256sum] = "0f384ec20c579b80d1960a5795d6517a6885305efa9964bcbf6a7b8da88b9c77"

inherit distutils
