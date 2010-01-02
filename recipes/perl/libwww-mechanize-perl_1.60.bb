DESCRIPTION = "WWW::Mechanize   	 Handy web browsing in a Perl object"
SECTION = "libs"
LICENSE = "Perl"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PETDANCE/WWW-Mechanize-${PV}.tar.gz"

S = "${WORKDIR}/WWW-Mechanize-${PV}"

inherit cpan

BBCLASSEXTEND="native"
