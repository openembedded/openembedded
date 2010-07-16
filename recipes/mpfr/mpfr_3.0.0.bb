require mpfr.inc

DEPENDS = "gmp"
S = "${WORKDIR}/mpfr-${PV}"
NATIVE_INSTALL_WORKS = "1"
PR = "r0"
BBCLASSEXTEND = "native"

SRC_URI = "http://www.mpfr.org/mpfr-${PV}/mpfr-${PV}.tar.xz \
           file://p3.patch"
SRC_URI[md5sum] = "8ab3bef2864b8c6e6a291f5603141bbd"
SRC_URI[sha256sum] = "22de51fee8ccfae75eaea85938acf8c9d8e9415269d9abb7ced52ebf0a29b5d8"
