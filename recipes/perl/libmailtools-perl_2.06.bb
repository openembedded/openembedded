DESCRIPTION = "MailTools is a set of Perl modules related to mail applications"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = " \
	libtest-pod-perl-native \
	libtimedate-perl-native \
	"	
RDEPENDS_${PN} += " \
	libtest-pod-perl \
	libtimedate-perl \
	perl-module-io-handle \
	perl-module-net-smtp \
	perl-module-test-more \
	"
BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MARKOV/MailTools-${PV}.tar.gz;name=mailtools-perl-${PV}"
SRC_URI[mailtools-perl-2.06.md5sum] = "3f90297c7f566cc0cc9c89ee47906abf"
SRC_URI[mailtools-perl-2.06.sha256sum] = "b92b728c1f36dec9a0f44ed5650db4745cf1fca21f7a5e89b890c888eedcb3db"

S = "${WORKDIR}/MailTools-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
