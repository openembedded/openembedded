DESCRIPTION = "Params::Util - Simple, compact and correct param-checking functions"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-exporter perl-module-overload \
             perl-module-scalar-util perl-module-strict perl-module-vars"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/Params-Util-${PV}.tar.gz"

S = "${WORKDIR}/Params-Util-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "33c4466239c97cc3e1063eff0577206c"
SRC_URI[sha256sum] = "29f7e05045a5699b211d2a8332d36113c22f9c2e96174f40939e79dbc356905d"
