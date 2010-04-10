require qpf.inc

DESCRIPTION = "FreeSerif font - QPF Edition"
HOMEPAGE = "http://savannah.nongnu.org/projects/freefont/"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/${PN}-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "a7fa0210e02f42d5b14245e260bc72c3"
SRC_URI[sha256sum] = "c8ee6e5e62b0a182dbee85865e56b1572e6875769b8256b39c75b2334a283e45"
