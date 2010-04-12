DESCRIPTION = "A routing daemon for the OLSR protocol prepared for QoS enhancements."
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://qolsr.lri.fr"
PR = "r0"

SRC_URI = "http://qolsr.lri.fr/code/qolyester-${PV}.tar.bz2"

inherit autotools


SRC_URI[md5sum] = "922ac0c5a70d8bcba50b23009b3c4878"
SRC_URI[sha256sum] = "81ce65c833ecd7c98d0af1d19419a3d93af811d99865ed2c8b377a7e507af4a7"
