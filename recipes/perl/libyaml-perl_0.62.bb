DESCRIPTION = "YAML - YAML Ain't Markup Language (tm)"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libdigest-sha1-perl-native liberror-perl-native \
           libipc-sharelite-perl-native"
RDEPENDS = "libdigest-sha1-perl liberror-perl libipc-sharelite-perl"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/I/IN/INGY/YAML-${PV}.tar.gz"

S = "${WORKDIR}/YAML-${PV}"

inherit cpan

BBCLASSEXTEND="native"
