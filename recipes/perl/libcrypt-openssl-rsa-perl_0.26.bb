DESCRIPTION = "RSA encoding and decoding, using the openSSL libraries"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "openssl"
RDEPENDS_${PN} += " \
	libcrypt-openssl-bignum-perl \
	libcrypt-openssl-random-perl \
	"
BBCLASSEXTEND = "native"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/I/IR/IROBERTS/Crypt-OpenSSL-RSA-${PV}.tar.gz;name=crypt-openssl-rsa-perl-${PV}"
SRC_URI[crypt-openssl-rsa-perl-0.26.md5sum] = "baf875f01ee39b88335b8f0962fe4bbc"
SRC_URI[crypt-openssl-rsa-perl-0.26.sha256sum] = "f42f276ffe5ae1775c4bd76f3026483f0d39975f7cdd07bf48eccfb8c45286bb"

S = "${WORKDIR}/Crypt-OpenSSL-RSA-${PV}"

inherit cpan