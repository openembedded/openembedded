DESCRIPTION = "Net::SSLeay - Perl extension for using OpenSSL"
SECTION = "libs"
LICENSE = "OpenSSL"
DEPENDS = "openssl zlib"
RDEPENDS_${PN} += " \
	perl-module-carp \
	perl-module-errno \
	perl-module-extutils-makemaker \
	perl-module-mime-base64 \
	perl-module-socket \
	"

BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/F/FL/FLORA/Net-SSLeay-${PV}.tar.gz;name=net-ssleay-${PV}"
SRC_URI[net-ssleay-1.36.md5sum] = "54061638720dd6a325395331c77f21d8"
SRC_URI[net-ssleay-1.36.sha256sum] = "e262897263c5aa9096e39f7813c7cb7d4d05508ca406b173878c4ecddb2c53ce"

S = "${WORKDIR}/Net-SSLeay-${PV}"

export OPENSSL_PREFIX="${STAGING_INCDIR}/.."

inherit cpan
