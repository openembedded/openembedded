DESCRIPTION = "WWW::Mechanize   	 Handy web browsing in a Perl object"
SECTION = "libs"
LICENSE = "Perl"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PETDANCE/WWW-Mechanize-${PV}.tar.gz"

S = "${WORKDIR}/WWW-Mechanize-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "bd3bf56f28881c5363d1c599ff43a632"
SRC_URI[sha256sum] = "8844dbc7f695fbc9f87e04895295fc61260559df7176b3159cd3dc2c70863478"
