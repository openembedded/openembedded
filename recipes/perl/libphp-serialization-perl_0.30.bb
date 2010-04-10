DESCRIPTION = "The standard database interface module for Perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/B/BO/BOBTFISH/PHP-Serialization-${PV}.tar.gz"

S = "${WORKDIR}/PHP-Serialization-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "210b764fca7c791f4387717185f589b5"
SRC_URI[sha256sum] = "09917ebe3b088649f0767723a7e25ae08fb8db921a85183e2e8c3d2e79ae6d10"
