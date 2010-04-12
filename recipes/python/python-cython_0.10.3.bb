DESCRIPTION = "Cython is a language specially designed for writing Python extension modules. \
It's designed to bridge the gap between the nice, high-level, easy-to-use world of Python \
and the messy, low-level world of C."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "Cython"
PR = "ml0"

SRC_URI = "http://www.cython.org/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "684103ed37472d9beef3a38e0d5c431d"
SRC_URI[sha256sum] = "a9ac41b270743c067456272a1a0c788008b41f64f388488dfbac54e2a78303b8"
