DESCRIPTION = "XML-NamespaceSupport"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PERIGRIN/XML-NamespaceSupport-${PV}.tar.gz"
SRC_URI[md5sum] = "222cca76161cd956d724286d36b607da"
SRC_URI[sha256sum] = "6d8151f0a3f102313d76b64bfd1c2d9ed46bfe63a16f038e7d860fda287b74ea"


S = "${WORKDIR}/XML-NamespaceSupport-${PV}"

inherit cpan

BBCLASSEXTEND="native"

