DESCRIPTION = "HTTP::Cache::Transparent - Cache the result of http get-requests persistently."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

DEPENDS += "libwww-perl liburi-perl libhtml-tagset-perl libhtml-parser-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MATTIASH/HTTP-Cache-Transparent-${PV}.tar.gz"

S = "${WORKDIR}/HTTP-Cache-Transparent-${PV}"

inherit cpan

BBCLASSEXTEND="native"
