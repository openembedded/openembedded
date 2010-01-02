DESCRIPTION = "Cache::Cache -- the Cache interface."
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libdigest-sha1-perl-native liberror-perl-native \
           libipc-sharelite-perl-native"
RDEPENDS = "libdigest-sha1-perl liberror-perl libipc-sharelite-perl"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JS/JSWARTZ/Cache-Cache-${PV}.tar.gz"

S = "${WORKDIR}/Cache-Cache-${PV}"

inherit cpan

BBCLASSEXTEND="native"
