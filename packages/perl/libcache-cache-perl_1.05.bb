DESCRIPTION = "Cache::Cache -- the Cache interface."
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libdigest-sha1-perl-native liberror-perl-native \
           libipc-sharelite-perl-native"
RDEPENDS = "libdigest-sha1-perl liberror-perl libipc-sharelite-perl"
PR = "r6"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DC/DCLINTON/Cache-Cache-${PV}.tar.gz"

S = "${WORKDIR}/Cache-Cache-${PV}"

inherit cpan
