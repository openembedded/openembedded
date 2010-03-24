DESCRIPTION = "OpenSSL's multiprecision integer arithmetic"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "openssl"
BBCLASSEXTEND = "native"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/I/IR/IROBERTS/Crypt-OpenSSL-Bignum-${PV}.tar.gz;name=crypt-openssl-bignum-perl-${PV}"
SRC_URI[crypt-openssl-bignum-perl-0.04.md5sum] = "9369ef722b0705c0604998559988eb18"
SRC_URI[crypt-openssl-bignum-perl-0.04.sha256sum] = "73a1e3a2419054a5109629c55d3ec322415be07d6bb6029b830a30e8f1126fa3"

S = "${WORKDIR}/Crypt-OpenSSL-Bignum-${PV}"

inherit cpan