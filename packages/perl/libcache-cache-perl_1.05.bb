DESCRIPTION = "Cache::Cache -- the Cache interface."
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "libdigest-sha1-perl-native liberror-perl-native \
           libipc-sharelite-perl-native"
RDEPENDS = "libdigest-sha1-perl liberror-perl libipc-sharelite-perl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DC/DCLINTON/Cache-Cache-1.05.tar.gz"

S = "${WORKDIR}/Cache-Cache-${PV}"

inherit cpan
