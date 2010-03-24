DESCRIPTION = "MIME-tools - modules for parsing (and creating!) MIME entities"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = " \
	libio-stringy-perl-native \
	libmailtools-perl-native \
	libtest-pod-perl-native \
	libtimedate-perl-native \
	"
RDEPENDS_${PN} += "\
	libio-stringy-perl \
	libmailtools-perl \
	libtest-pod-perl \
	perl-module-file-path \
	perl-module-file-spec \
	perl-module-file-temp \
	perl-module-io-file \
	perl-module-mime-base64 \
	perl-module-net-smtp \
	perl-module-test-more \
	"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DO/DONEILL/MIME-tools-${PV}.tar.gz;name=mime-tools-perl-${PV}"
SRC_URI[mime-tools-perl-5.427.md5sum] = "4333caa7238cb9eafb5f7fb39fcbd8e7"
SRC_URI[mime-tools-perl-5.427.sha256sum] = "844d2499fd2934d4836bd86dc73dd51955aea3fd88109b9d559d99449851fe6e"

S = "${WORKDIR}/MIME-tools-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
