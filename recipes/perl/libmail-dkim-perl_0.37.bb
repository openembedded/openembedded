DESCRIPTION = "Mail::DKIM - Signs/verifies Internet mail with DKIM/DomainKey signatures"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = " \
	libcrypt-openssl-rsa-perl-native \
	libdigest-sha-native \
	libmailtools-perl-native \
	libnet-dns-perl-native \
	"
RDEPENDS_${PN} += " \
	libcrypt-openssl-rsa-perl \
	libdigest-sha \
	liberror-perl \
	libmailtools-perl \
	libnet-dns-perl \
	"
BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JA/JASLONG/Mail-DKIM-${PV}.tar.gz;name=mail-dkim-perl-${PV}"
SRC_URI[mail-dkim-perl-0.37.md5sum] = "f3e84ec6b5e42d4cbcc7c42ea2900649"
SRC_URI[mail-dkim-perl-0.37.sha256sum] = "287173596f2e4ad4a44385d7ebbf868114d52ce73bd8d931b8dcf5c5ce19ad0b"

S = "${WORKDIR}/Mail-DKIM-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
