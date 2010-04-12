DESCRIPTION = "Digest::SHA1 - Perl interface to the SHA-1 algorithm"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r14"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/Digest-SHA1-${PV}.tar.gz"

S = "${WORKDIR}/Digest-SHA1-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Digest/SHA1/* \
               ${PERLLIBDIRS}/Digest"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "2449bfe21d6589c96eebf94dae24df6b"
SRC_URI[sha256sum] = "3cebe0a6894daee3bfa5d9619fc90e7619cb6a77ac1b04d027341cd6033ae989"
