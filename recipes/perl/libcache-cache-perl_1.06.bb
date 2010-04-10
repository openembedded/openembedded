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

SRC_URI[md5sum] = "4425f44ddb138a799290802e5aad46ef"
SRC_URI[sha256sum] = "703d93793ab0b3bd984cfde89943ce1a98c0991f94afc9d1d531c752f52a4793"
