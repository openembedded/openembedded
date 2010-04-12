DESCRIPTION = " Python module to handle audio metadata"
HOMEPAGE = "http://code.google.com/p/quodlibet/wiki/Development/Mutagen"
SECTION = "devel/python"
LICENSE = "GPL"
PR = "0"

SRC_URI = "http://www.sacredchao.net/~piman/software/${PN}-${PV}.tar.gz"

inherit distutils

SRC_URI[md5sum] = "c346e1290711a38c123727c31f3602f8"
SRC_URI[sha256sum] = "636d816aa4c7e754496b9daec8a00d7e5f62b67d640440c91dea6d694c83c944"
