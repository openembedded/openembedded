DESCRIPTION = "HTTP::Cache::Transparent - Cache the result of http get-requests persistently."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

DEPENDS += "libwww-perl liburi-perl libhtml-tagset-perl libhtml-parser-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MATTIASH/HTTP-Cache-Transparent-${PV}.tar.gz"

S = "${WORKDIR}/HTTP-Cache-Transparent-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "e198345ce8eee2562c807e84d65e3b4f"
SRC_URI[sha256sum] = "31b6b54d9488b35eb8ca54b6f5bcefd6eb1e208ca8a4038c1cee61042747f1d9"
