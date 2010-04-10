require qpf.inc

DESCRIPTION = "FreeMono font - QPF Edition"
HOMEPAGE = "http://savannah.nongnu.org/projects/freefont/"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.openzaurus.org/download/3.5.4/sources/${PN}-${PV}.tar.bz2"

S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "28688d47cd80d3a6bb833adb22292e15"
SRC_URI[sha256sum] = "5ac0513efe6270d45a2ada5dc653c434677da4282e026d8c1a9c156cd99e11c8"
