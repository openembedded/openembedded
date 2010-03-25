DESCRIPTION = "Modules to assemble/disassemble network packets at the protocol level"
SECTION = "libs"
LICENSE = "Artistic"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/Y/YA/YANICK/NetPacket-${PV}.tar.gz;name=netpacket-perl-${PV}"
SRC_URI[netpacket-perl-0.41.1.md5sum] = "77c1482927c6892b9571404485ffe591"
SRC_URI[netpacket-perl-0.41.1.sha256sum] = "8d27fd064b9a6abf5298c62fef0f9775b45004efa8eb4cc72b7af73a7241303d"


S = "${WORKDIR}/NetPacket-${PV}"

inherit cpan_build

PACKAGE_ARCH = "all"
