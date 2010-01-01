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
