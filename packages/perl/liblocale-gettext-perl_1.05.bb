DESCRIPTION = "Locale::gettext - message handling functions"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "virtual/libintl"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PV/PVANDRY/gettext-${PV}.tar.gz"

S = "${WORKDIR}/gettext-${PV}"

inherit cpan
