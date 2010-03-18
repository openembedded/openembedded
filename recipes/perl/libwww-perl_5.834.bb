DESCRIPTION = "libwww-perl provides a simple and consistent API to the World Wide Web"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "liburi-perl-native libhtml-parser-perl-native libhtml-tagset-perl-native"
RDEPENDS_${PN} += " \
	libhtml-parser-perl \
	libhtml-tagset-perl \
	liburi-perl \
	perl-module-digest-md5 \
	perl-module-net-ftp \
	"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/libwww-perl-${PV}.tar.gz;name=libwww-perl-${PV}"
SRC_URI[libwww-perl-5.834.md5sum] = "f2ed8a461f76556c9caed9087f47c86c"
SRC_URI[libwww-perl-5.834.sha256sum] = "1a50eb91d1deeca3be10982e129e786809ad6f0f8049b156e91e889e5a7288ff"

S = "${WORKDIR}/libwww-perl-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
