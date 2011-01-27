DESCRIPTION = "YAML - YAML Ain't Markup Language (tm)"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = "libdigest-sha1-perl-native liberror-perl-native \
           libipc-sharelite-perl-native"
RDEPENDS_${PN} = "libdigest-sha1-perl liberror-perl libipc-sharelite-perl"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/I/IN/INGY/YAML-${PV}.tar.gz"

S = "${WORKDIR}/YAML-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "4be042a043ec520074b0ab6f7ca0bded"
SRC_URI[sha256sum] = "fa668e8f01fe43fdddb33f0c5e294698818f37519000b9f782f504ece071c740"
