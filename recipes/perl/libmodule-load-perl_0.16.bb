DESCRIPTION = "A module loading thingy for perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KA/KANE/Module-Load-${PV}.tar.gz"

S = "${WORKDIR}/Module-Load-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "851a225e31621a66621f28a25ec53d9a"
SRC_URI[sha256sum] = "f05c3300c988dc5f5f02d55f8ee241c05fbf4565c512f804f47c6e72e5f69e33"
